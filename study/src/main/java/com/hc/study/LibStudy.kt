package com.hc.study

/**
 *
 * @author:        Created by hc
 * @date:          Create in 14:55 2021/8/1
 * @description:
 *
 */

import com.hc.common.network.KtRetrofit
import com.hc.common.utils.getBaseHost
import com.hc.study.net.StudyService
import com.hc.study.repo.IStudyResource
import com.hc.study.repo.StudyResource
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.bind
import org.koin.dsl.module

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

    single {
        get<KtRetrofit> { parametersOf(getBaseHost()) }.getService(StudyService::class.java)
    }

    //repo IMineResource
    single { StudyResource(get()) } bind IStudyResource::class

    viewModel { StudyViewModel(get()) }

}