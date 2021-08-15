package com.hc.mine

import org.koin.dsl.module

/**
 * Created by hcw  on 2021/7/10
 * 类描述：
 * all rights reserved
 */

/*
* koin的mine module
* */
val moduleMine = module {

    //service retrofit
    //single声明单例对象
    // single {
    //     KtRetrofit.initConfig("http://yapi.54yct.com/mock/24/") //baseurl
    //         .getService(MineService::class.java)
    // }
//    single {
//        get<KtRetrofit> { parametersOf(getBaseHost()) }.getService(MineService::class.java)
//    }
//
//    //repo IMineResource
//    single { MineRepo(get()) } bind IMineResource::class
//
//    viewModel { MineViewModel(get()) }
}