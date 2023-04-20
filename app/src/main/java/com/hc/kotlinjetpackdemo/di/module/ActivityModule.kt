package com.hc.kotlinjetpackdemo.di.module


/**
 * @Author: wanghaichao
 * @Date: 2023/4/20
 * @Description:
 * @Copyright: all rights reserved.
 */
//@Module
//class ActivityModule(private val activity: AppCompatActivity) {
//
//    @ActivityContext
//    @Provides
//    fun provideContext(): Context {
//        return activity
//    }
//
//    @Provides
//    fun provideTopHeadlineViewModel(topHeadlineRepository: TopHeadlineRepository): TopHeadlineViewModel {
//        return ViewModelProvider(activity,
//            ViewModelProviderFactory(TopHeadlineViewModel::class) {
//                TopHeadlineViewModel(topHeadlineRepository)
//            })[TopHeadlineViewModel::class.java]
//    }
//
//    @Provides
//    fun provideTopHeadlineAdapter() = TopHeadlineAdapter(ArrayList())
//
//}