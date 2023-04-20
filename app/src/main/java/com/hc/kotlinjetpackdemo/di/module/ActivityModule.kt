package com.hc.kotlinjetpackdemo.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hc.kotlinjetpackdemo.data.repository.TopHeadlineRepository
import com.hc.kotlinjetpackdemo.di.ActivityContext
import com.hc.kotlinjetpackdemo.ui.base.ViewModelProviderFactory
import com.hc.kotlinjetpackdemo.ui.topheadline.TopHeadlineAdapter
import com.hc.kotlinjetpackdemo.ui.topheadline.TopHeadlineViewModel
import dagger.Module
import dagger.Provides

/**
 * @Author: wanghaichao
 * @Date: 2023/4/20
 * @Description:
 * @Copyright: all rights reserved.
 */
@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideTopHeadlineViewModel(topHeadlineRepository: TopHeadlineRepository): TopHeadlineViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(TopHeadlineViewModel::class) {
                TopHeadlineViewModel(topHeadlineRepository)
            })[TopHeadlineViewModel::class.java]
    }

    @Provides
    fun provideTopHeadlineAdapter() = TopHeadlineAdapter(ArrayList())

}