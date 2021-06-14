package com.hc.common.network

import com.hc.common.network.support.IHttpCallback

/**
 * Created by hcw  on 2021/5/15
 * 类描述：
 * all rights reserved
 */

/***
 *
 * 网络请求的统一接口类
 *
 */
interface HttpApi {

    /**
     * 抽象的http的get请求封装,异步
     */
    fun get(params: Map<String, Any>, urlStr: String, callback: IHttpCallback)


    /**
     * 抽象的http同步的 get请求
     */
    fun getSync(params: Map<String, Any>, urlStr: String): Any? {
        return Any()
    }

    /**
     * 抽象的http的post的请求 异步
     */
    fun post(body: Any, urlStr: String, callback: IHttpCallback)

    /**
     * 抽象的Http的post 同步请求
     */
    fun postSync(body: Any, urlStr: String): Any? = Any()


    //取消机制，请求管理，okttp 里面支持。
    fun cancelRequest(tag: Any)

    fun cancelAllRequest()

}














