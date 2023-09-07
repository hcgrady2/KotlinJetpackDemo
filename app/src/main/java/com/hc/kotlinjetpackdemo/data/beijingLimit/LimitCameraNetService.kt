package com.hc.kotlinjetpackdemo.data.beijingLimit

import retrofit2.http.GET

/**
 * @Author: wanghaichao
 * @Date: 2023/9/7
 * @Description:
 * @Copyright: all rights reserved.
 */
interface LimitCameraNetService {

    @GET("address/list")
    suspend fun getAllData(): LimitBean

}