package com.hc.kotlinjetpackdemo.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hc.kotlinjetpackdemo.data.repository.RetrofitMainRepository
import com.hc.kotlinjetpackdemo.utils.Resource
import kotlinx.coroutines.Dispatchers

/**
 * @Author: wanghaichao
 * @Date: 2023/4/20
 * @Description:
 * @Copyright: all rights reserved.
 */
class RetrofitMainViewModel(private val mainRepository: RetrofitMainRepository) : ViewModel() {

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}