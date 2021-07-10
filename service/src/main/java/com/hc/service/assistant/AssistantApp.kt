package com.hc.service.assistant

import android.app.Application
import com.didichuxing.doraemonkit.DoraemonKit

/**
 * Created by hcw  on 2021/7/10
 * 类描述：
 * all rights reserved
 */

/*
* 配置dokit的工具类
* */
object AssistantApp {

    fun initConfig(application: Application){
        DoraemonKit.install(application, mutableListOf(ServiceHostKit()))
    }

}