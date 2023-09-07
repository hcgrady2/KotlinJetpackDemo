package com.hc.kotlinjetpackdemo.limitDemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hc.kotlinjetpackdemo.data.api.ApiHelper
import com.hc.kotlinjetpackdemo.data.beijingLimit.LimitApiHelper
import com.hc.kotlinjetpackdemo.data.beijingLimit.RetrofitLimitRepository
import com.hc.kotlinjetpackdemo.data.repository.RetrofitMainRepository
import com.hc.kotlinjetpackdemo.ui.main.RetrofitLimitViewModel
import com.hc.kotlinjetpackdemo.ui.main.RetrofitMainViewModel

/**
 * @Author: wanghaichao
 * @Date: 2023/9/7
 * @Description:
 * @Copyright: all rights reserved.
 */
class LimitRetrofitViewModelFactory(private val apiHelper: LimitApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RetrofitLimitViewModel::class.java)) {
            return RetrofitLimitViewModel(RetrofitLimitRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}