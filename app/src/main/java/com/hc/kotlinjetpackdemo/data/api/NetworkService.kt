package com.hc.kotlinjetpackdemo.data.api

import com.hc.kotlinjetpackdemo.data.model.TopHeadlinesResponse
import com.hc.kotlinjetpackdemo.data.model.User
import com.hc.kotlinjetpackdemo.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import javax.inject.Singleton

/**
 * @Author: wanghaichao
 * @Date: 2023/4/20
 * @Description:
 * @Copyright: all rights reserved.
 */
interface NetworkService {

    @Headers("X-Api-Key: $API_KEY")
    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") country: String): TopHeadlinesResponse


    @GET("users")
    suspend fun getUsers(): List<User>


}