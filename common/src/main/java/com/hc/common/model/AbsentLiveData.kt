package com.hc.common.model;

import androidx.lifecycle.LiveData


/**
 *
 * 创建一个空的liveData的对象类
 *
 * */
class AbsentLiveData<T:Any?> private constructor():LiveData<T>(){


     init {
         postValue(null)
     }

    /**
     * 伴生类
     */
    companion object{
        fun <T:Any?> create():LiveData<T>{
            return AbsentLiveData()
        }

    }

}
















