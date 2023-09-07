package com.hc.kotlinjetpackdemo.data.beijingLimit

import com.hc.kotlinjetpackdemo.data.api.ApiHelper

/**
 * @Author: wanghaichao
 * @Date: 2023/9/7
 * @Description:
 * @Copyright: all rights reserved.
 */
class RetrofitLimitRepository(private val apiHelper: LimitApiHelper) {

    suspend fun getLimitInfos() = apiHelper.getLimitInfos()
}