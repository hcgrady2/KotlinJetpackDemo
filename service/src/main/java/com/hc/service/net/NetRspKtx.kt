package com.hc.service.net

import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.LogUtils
import com.google.gson.Gson
import com.hc.common.network.model.DataResult
import com.hc.common.network.model.succeeded
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 *
 * @author:        Created by hc
 * @date:          Create in 15:05 2021/8/1
 * @description:
 *
 */

/**
 * 这里表示网络请求成功，并得到业务服务器的响应
 * 将BaseCniaoRsp的对象，转化为需要的对象类型，也就是将body.string转为entity
 * @return 返回需要类型对象，可能为null，如果json解析失败的话
 * 加了reified才可以T::class.java
 */
inline fun <reified T> BaseResponse.toEntity(): T? {
    if (data == null) {
        LogUtils.e("server Response Json Ok,But data==null,$code,$message")
        return null
    }

    //todo 如果有需要的话在这里对返回的data数据进行解密然后再tojson fromjson

    // val decodeData = CnUtils.decodeData(data.toString())
    //gson不允许我们将json对象采用String,所以单独处理
    // if (T::class.java.isAssignableFrom(String::class.java)) {
    //     return decodeData as T
    // }

    //如果data不为空，先进行tojson处理再转化为T对象类型的entity string
    //传入LoginRsp就是LoginRsp  传入RegisterRsp就是RegisterRsp
    return kotlin.runCatching {
        // if (data is JsonObject){
        // } else if (data is JsonArray) {
        //     return GsonUtils.fromJson(Gson())
        // }
        LogUtils.e("返回结果： $data")

        GsonUtils.fromJson(Gson().toJson(data), T::class.java)
    }.onFailure { e ->
        e.printStackTrace() //Catch出错，报错
    }.getOrNull() //不为空
}

/**
 * 接口成功，但是业务返回code不是1或1001的情况
 */
@OptIn(ExperimentalContracts::class)
inline fun BaseResponse.onBizError(crossinline block: (code: Int, message: String?) -> Unit): BaseResponse {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }
    if (code != BaseResponse.SERVER_CODE_SUCCESS1 && code != BaseResponse.SERVER_CODE_SUCCESS) { //同时不等于1和1001的时候执行if
        block.invoke(code, message ?: "Error Message Null") //返回错误码和错误信息
    }
    return this
}



/**
 * 接口成功且业务成功code==1的情况
 * crossinline关键字 只要标志了就不能进入return true函数快
 */
@OptIn(ExperimentalContracts::class)
inline fun <reified T> BaseResponse.onBizOK(crossinline action: (code: Int, data: T?, message: String?) -> Unit): BaseResponse {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    if (code == BaseResponse.SERVER_CODE_SUCCESS || code == BaseResponse.SERVER_CODE_SUCCESS1) { //code == 1001或code == 1,成功
        action.invoke(code, this.toEntity<T>(), message) //返回成功码和解密之后的序列化对象
    }
    return this
}

/*
* 扩展用于处理网络返回数据结果 网络接口请求成功，但是业务成功与否不一定
* 注解 使用的是一个实验性的特性 需要在.gradel编译器中添加参数注明
* */
@OptIn(ExperimentalContracts::class)
inline fun <R> DataResult<R>.onSuccess(action: R.() -> Unit): DataResult<R> {
    //契约关系,契约关系，会进行状态判断
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE) //最多走一次
    }
    if (succeeded) action.invoke((this as DataResult.Success).data)
    return this
}

/*
* 扩展用于处理网络返回数据结果 网络请求出现错误的时候的回调
* */
@OptIn(ExperimentalContracts::class)
inline fun <R> DataResult<R>.onFailure(action: (exception: Throwable) -> Unit) : DataResult<R> {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    if (this is DataResult.Error) action.invoke(exception)
    return this
}

