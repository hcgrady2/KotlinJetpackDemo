package com.hc.course

import com.hc.common.network.KtRetrofit
import com.hc.common.utils.getBaseHost
import com.hc.course.net.CourseService
import com.hc.course.repo.CourseResource
import com.hc.course.repo.ICourseResource
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Created by hcw  on 2021/7/10
 * 类描述：
 * all rights reserved
 */
/*
* 课程模块的 module
* */
/*
* 课程模块的 module
* */
val moduleCourse = module {

    //service retrofit
    // single声明单例对象
    // single {
    //     KtRetrofit.initConfig("https://course.api.cniao5.com/") //baseurl
    //         .getService(CourseService::class.java)
    // }

    single {
        get<KtRetrofit> { parametersOf(getBaseHost()) }.getService(CourseService::class.java)
    }

    //repo IMineResource
    single { CourseResource(get()) } bind ICourseResource::class

    viewModel { CourseViewModel(get()) }

    viewModel { PlayVideoViewModel(get()) }

}