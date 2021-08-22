package com.hc.login

import com.hc.common.BaseApplication
import com.hc.service.moduleService
import org.koin.core.context.loadKoinModules

class LoginApplication : BaseApplication() {


    override fun initConfig() {
        super.initConfig()
        loadKoinModules(moduleService)
        loadKoinModules(moduleLogin)
    }


}