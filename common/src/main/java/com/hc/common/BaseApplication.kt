package com.hc.common

import android.app.Application
import com.blankj.utilcode.util.LogUtils
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

/**
 * Created by hcw  on 2021/5/15
 * 类描述：
 * all rights reserved
 */

/**
 * 抽象的公用BaseApplication
 */
abstract class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //koin的注解使用 ，支持模块化和组件化
        startKoin{
            androidLogger(Level.ERROR)//目前已知bug，除了level.error外，使用androidlogger会导致崩溃
            //context
            androidContext(this@BaseApplication)
            //assets 资源数据
            androidFileProperties("ass.file")//默认取值assets下koin.properties文件内的属性配置，可自定义
            //加载需要的module
            modules(cnModules)
        }

        //Koin加载外部的外部 module
        loadKoinModules(otherModuel)

        initConfig()
        initData()

        LogUtils.d("BaseApplication onCreate")


    }

    /**
     * 可用于必要的配置初始化
     */
    protected open fun initConfig() {}

    /**
     * 可用于子类实现必要的数据初始化
     */
    protected open fun initData() {}



    val cnModules = module{

    }


    val otherModuel = module {

    }



}
