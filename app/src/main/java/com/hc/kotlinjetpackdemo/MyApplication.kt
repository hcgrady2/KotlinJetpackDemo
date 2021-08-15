package com.hc.kotlinjetpackdemo

import com.alibaba.android.arouter.launcher.ARouter
import com.hc.common.BaseApplication
import com.hc.common.ktx.application
import com.hc.course.moduleCourse
import com.hc.home.moduleHome
import com.hc.login.moduleLogin
import com.hc.mine.moduleMine
import com.hc.service.assistant.AssistantApp
import com.hc.service.moduleService
import com.hc.study.moduleStudy
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module

/**
 * Created by hcw  on 2021/7/10
 * 类描述：
 * all rights reserved
 */
class MyApplication : BaseApplication() {

    private val modules = arrayListOf<Module>(
        moduleService, moduleHome, moduleLogin, moduleMine, moduleStudy, moduleCourse
    )

    override fun initConfig() {
        super.initConfig()

        //添加common模块之外的其他模块，组件的koin的modules
        loadKoinModules(modules)

        //doKit的初始化配置
        AssistantApp.initConfig(application)

        //初始化Arouter框架
        ARouter.init(application)
    }

}