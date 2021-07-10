package com.hc.study

import org.koin.dsl.module

/**
 * Created by hcw  on 2021/7/10
 * 类描述：
 * all rights reserved
 */
/*
* 依赖注入管理 study的module
* */
val moduleStudy = module {

    //service retrofit
    //single声明单例对象
    // single {
    //     KtRetrofit.initConfig("http://yapi.54yct.com/mock/24/") //baseurl
    //         .getService(MineService::class.java)
    // }

//    single {
//        get<KtRetrofit> { parametersOf(getBaseHost()) }.getService(StudyService::class.java)
//    }
//
//    //repo IMineResource
//    single { StudyResource(get()) } bind IStudyResource::class
//
//    viewModel { StudyViewModel(get()) }

}