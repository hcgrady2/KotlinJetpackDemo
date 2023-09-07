package com.hc.kotlinjetpackdemo.data.beijingLimit

import com.hc.kotlinjetpackdemo.data.api.NetworkService

/**
 * @Author: wanghaichao
 * @Date: 2023/9/7
 * @Description:
 * @Copyright: all rights reserved.
 */
class LimitApiHelper(private val apiService: LimitCameraNetService) {

    suspend fun getLimitInfos() = apiService.getAllData()
}