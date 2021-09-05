package com.hc.common.network.config

import com.blankj.utilcode.util.*
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.CacheControl
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer

/**
 * Created by hcw  on 2021/5/15
 * 类描述：
 * all rights reserved
 */


/**
 * 网络框架 添加公共header的拦截器
 *
 * */
class CniaoHeaderInterceptor : Interceptor {

    companion object{
        private  val gson = GsonBuilder()
            .enableComplexMapKeySerialization()
            .create()
        private  val mapType =  object : TypeToken<Map<String, Any>>() {}.type
    }



    override fun intercept(chain: Interceptor.Chain): Response {
        val originRequest = chain.request()
        //附加的公共headers，封装clientInfo,deviceInfo等。也可以在post请求中，自定义封装headers的字段体内容
        //注意这里，服务器用于校验的字段，只能是以下的字段内容，可以缺失，但不能额外添加，因为服务端未做处理
        //附加的公共headers，封装clientInfo,deviceInfo等。也可以在post请求中，自定义封装headers的字段体内容
        //注意这里，服务器用于校验的字段，只能是以下的字段内容，可以缺失，但不能额外添加，因为服务端未做处理
        val attachHeaders = mutableListOf<Pair<String, String>>(
            "appid" to NET_CONFIG_APPID,
            "platform" to "android",//如果重复请求，可能会报重复签名错误，yapi 平台标记则不会
            "timestamp" to System.currentTimeMillis().toString(),

            "brand" to DeviceUtils.getManufacturer(),
            "model" to DeviceUtils.getModel(),
            "uuid" to DeviceUtils.getUniqueDeviceId(),
            "network" to NetworkUtils.getNetworkType().name,
            "system" to DeviceUtils.getSDKVersionName(),


            "version" to AppUtils.getAppVersionName()
        )
        //从sp里获取token仅在有值(只有在登陆成功后,)的时候才传递，才能添加
        /*  val localToken =CniaoSpUtils.getString(SP_KEY_USER_TOKEN,originRequest.header("token"))?:""
           if(localToken.isNotEmpty()){
               attachHeaders.add("token" to localToken)
           }*/

        //拦截 token
        val localToken = SPStaticUtils.getString(SP_KEY_USER_TOKEN, originRequest.header("token"))?:"tokenNull"
        if (localToken.isNotEmpty()) {
            attachHeaders.add("token" to localToken)
        }

        val signHeaders = mutableListOf<Pair<String, String>>()
        signHeaders.addAll(attachHeaders)
        //get的请求，参数
        if(originRequest.method=="GET"){
            originRequest.url.queryParameterNames.forEach { key->
                signHeaders.add(key to (originRequest.url.queryParameter(key)?:""))
            }
        }
        //post的请求 formBody形式，或json形式的，都需要将内部的字段，遍历出来，参与sign的计算
        val requestBody =    originRequest.body
        if(originRequest.method=="POST"){
            //formBody
            if(requestBody is FormBody){
                for(i in 0 until requestBody.size){
                    signHeaders.add(requestBody.name(i) to requestBody.value(i))
                }
            }
            //json的body 需要将requestBody反序列化为json转为map application/json
            //json的body 需要将requestBody反序列化为json转为map application/json
            if (requestBody?.contentType()?.type == "application" && requestBody.contentType()?.subtype == "json") {
                kotlin.runCatching {
                    val buffer = Buffer()
                    requestBody.writeTo(buffer)
                    buffer.readByteString().utf8()
                }.onSuccess {
                    val map = gson.fromJson<Map<String, Any>>(it, mapType)
                    map.forEach { entry ->
                        // FIXME: 2020/8/25 value 目前json单层级
                        signHeaders.add(entry.key to entry.value.toString())
                    }
                }
            }
        }
        //todo 算法：都必须是非空参数！！！  sign = MD5（ascii排序后的 headers及params的key=value拼接&后，最后拼接appkey和value）//32位的大写,
        val signValue:String = signHeaders.sortedBy { it.first }
            .joinToString("&") { "${it.first}=${it.second}" }
            .plus("&appkey=$NET_CONFIG_APPKEY")

        val newBuilder = originRequest.newBuilder()
            .cacheControl(CacheControl.FORCE_NETWORK)
        attachHeaders.forEach { newBuilder.header(it.first, it.second) }
        newBuilder.header("sign", EncryptUtils.encryptMD5ToString(signValue))

        //拦截器，生成新的 REQUEST  .
        if (originRequest.method == "POST" && requestBody != null) {
            newBuilder.post(requestBody)
        } else if (originRequest.method == "GET") {
            newBuilder.get()
        }
        return  chain.proceed(newBuilder.build())
    }
}

