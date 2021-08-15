package com.hc.mine.net

import com.hc.service.net.BaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

/**
 *
 * @author:        Created by hc
 * @date:          Create in 22:32 2021/8/14
 * @description:
 *
 */

/*
* Mine模块相关的网络接口
* */

interface MineService {

    /*
    * 用户详情信息的获取
    * */
    @GET("member/userinfo")
    fun getUserInfo(@Header("token") token: String?) : Call<BaseResponse>

}