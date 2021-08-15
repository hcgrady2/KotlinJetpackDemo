package com.hc.login

import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by hcw  on 2021/7/10
 * 类描述：
 * all rights reserved
 */

/*
* koin注解管理类
* */
val moduleLogin: Module = module {

    //service retrofit
    //single声明单例对象
    // single {
    //     KtRetrofit.initConfig("http://yapi.54yct.com/mock/24/") //baseurl
    //         .getService(LoginService::class.java)
    // }

//    single {
//        get<KtRetrofit> { parametersOf(getBaseHost()) }.getService(LoginService::class.java)
//    }
//
//    //repo ILoginResource
//    single { LoginRepo(get()) } bind ILoginResource::class
//
//    //viewModel
//    viewModel { LoginViewModel(get()) }
}