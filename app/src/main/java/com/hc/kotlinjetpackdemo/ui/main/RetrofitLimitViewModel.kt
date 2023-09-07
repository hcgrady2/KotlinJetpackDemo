package com.hc.kotlinjetpackdemo.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hc.kotlinjetpackdemo.data.beijingLimit.RetrofitLimitRepository
import com.hc.kotlinjetpackdemo.data.repository.RetrofitMainRepository
import com.hc.kotlinjetpackdemo.utils.Resource
import kotlinx.coroutines.Dispatchers

/**
 * @Author: wanghaichao
 * @Date: 2023/9/7
 * @Description:
 * @Copyright: all rights reserved.
 */
class RetrofitLimitViewModel(private val limitRepository: RetrofitLimitRepository)
    : ViewModel() {

    fun getAllData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = limitRepository.getLimitInfos()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}