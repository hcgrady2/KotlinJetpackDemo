package com.hc.login

import com.blankj.utilcode.util.LogUtils
import com.hc.common.network.KtRetrofit
import com.hc.common.utils.getBaseHost
import com.hc.login.net.LoginService
import com.hc.login.repo.ILoginResource
import com.hc.login.repo.LoginRepo
import org.koin.androidx.viewmodel.compat.ViewModelCompat.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.dsl.bind
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



    //实例化
    single {
        LogUtils.e("获取的 baseURl " + getBaseHost() )

        get<KtRetrofit> { parametersOf(getBaseHost()) }.getService(LoginService::class.java)
    }

    //repo ILoginResource，必须 Bind
    single { LoginRepo(get()) } bind ILoginResource::class

    //viewModel
    viewModel { LoginViewModel(get()) }
}