package com.hc.kotlinjetpackdemo.data.api

/**
 * @Author: wanghaichao
 * @Date: 2023/4/20
 * @Description:
 * @Copyright: all rights reserved.
 */
class ApiHelper(private val apiService: NetworkService) {

    suspend fun getUsers() = apiService.getUsers()
}