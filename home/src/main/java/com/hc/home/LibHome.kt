package com.hc.home

import com.hc.common.network.KtRetrofit
import com.hc.common.utils.getBaseHost
import com.hc.home.net.HomeService
import com.hc.home.repo.HomeResource
import com.hc.home.repo.IHomeResource
import com.hc.home.ui.HomeViewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module


/**
 * Created by hcw  on 2021/7/10
 * 类描述：
 * all rights reserved
 */
/*
* 依赖注入管理 Home的module
* */
val moduleHome = module {

    //service retrofit
    //single声明单例对象
    // single {
    //     KtRetrofit.initConfig("http://yapi.54yct.com/mock/24/") //baseurl
    //         .getService(MineService::class.java)
    // }

    single {
        get<KtRetrofit> { parametersOf(getBaseHost()) }.getService(HomeService::class.java)
    }

    //repo IMineResource
    single { HomeResource(get()) } bind IHomeResource::class

    viewModel { HomeViewModel(get()) }

}