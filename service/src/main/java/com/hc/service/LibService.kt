package com.hc.service

import com.hc.common.network.KtRetrofit
import org.koin.dsl.module

/**
 * Created by hcw  on 2021/7/10
 * 类描述：
 * all rights reserved
 */

/*
* Service模块相关的koin的module配置
* */
val moduleService = module {

    //host作为外部参数传进来给KtRetrofit进行初始化，得到ktretrofit单例类对象
    single<KtRetrofit> { (host: String) -> KtRetrofit.initConfig(host) }

}