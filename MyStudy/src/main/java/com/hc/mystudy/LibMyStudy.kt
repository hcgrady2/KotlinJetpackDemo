package com.hc.mystudy

import com.hc.common.network.KtRetrofit
import com.hc.common.utils.getBaseHost
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * @Author: wanghaichao
 * @Date: 2023/4/20
 * @Description:
 * @Copyright: all rights reserved.
 */
/*
* 依赖注入管理 study的module
* */

/*
* Service模块相关的koin的module配置
* */
val moduleMyStudy = module {

    //host作为外部参数传进来给KtRetrofit进行初始化，得到ktretrofit单例类对象
    single<KtRetrofit> { (host: String) -> KtRetrofit.initConfig(host) }

}