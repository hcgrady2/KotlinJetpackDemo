package com.hc.kotlinjetpackdemo.di.component

import android.content.Context
import com.hc.kotlinjetpackdemo.ApplicationModule
import com.hc.kotlinjetpackdemo.MyApplication
import com.hc.kotlinjetpackdemo.data.api.NetworkService
import com.hc.kotlinjetpackdemo.data.repository.TopHeadlineRepository
import com.hc.kotlinjetpackdemo.di.ApplicationContext
import dagger.Component
import javax.inject.Singleton

/**
 * @Author: wanghaichao
 * @Date: 2023/4/20
 * @Description:
 * @Copyright: all rights reserved.
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getTopHeadlineRepository(): TopHeadlineRepository

}