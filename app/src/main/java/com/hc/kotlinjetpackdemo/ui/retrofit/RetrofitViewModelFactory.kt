package com.hc.kotlinjetpackdemo.ui.retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hc.kotlinjetpackdemo.data.api.ApiHelper
import com.hc.kotlinjetpackdemo.data.repository.RetrofitMainRepository
import com.hc.kotlinjetpackdemo.ui.main.RetrofitMainViewModel

/**
 * @Author: wanghaichao
 * @Date: 2023/4/20
 * @Description:
 * @Copyright: all rights reserved.
 */
class RetrofitViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RetrofitMainViewModel::class.java)) {
            return RetrofitMainViewModel(RetrofitMainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}