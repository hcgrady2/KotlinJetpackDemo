package com.hc.kotlinjetpackdemo.data.beijingLimit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Author: wanghaichao
 * @Date: 2023/9/7
 * @Description:
 * @Copyright: all rights reserved.
 */
object LimitCameraNetBuilder {

    private const val BASE_URL = "http://8.140.97.72:8081/address/list"

    private fun getRetrofit(baseUrl:String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter
    }
    val apiService: LimitCameraNetService = getRetrofit("http://8.140.97.72:8081/")
        .create(LimitCameraNetService::class.java)
}