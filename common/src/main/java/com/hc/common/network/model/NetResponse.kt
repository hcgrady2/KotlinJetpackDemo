package com.hc.common.network.model

/**
 * Created by hcw  on 2021/5/15
 * 类描述：
 * all rights reserved
 */
class NetResponse {
    var code: Int?=0//响应码
    var data: Any?=null//响应数据内容
    var message: String?=null//响应数据的结果描述
}