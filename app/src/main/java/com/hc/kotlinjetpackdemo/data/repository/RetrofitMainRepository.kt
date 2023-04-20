package com.hc.kotlinjetpackdemo.data.repository

import com.hc.kotlinjetpackdemo.data.api.ApiHelper

/**
 * @Author: wanghaichao
 * @Date: 2023/4/20
 * @Description:
 * @Copyright: all rights reserved.
 */
class RetrofitMainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
}