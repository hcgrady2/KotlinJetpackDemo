package com.hc.login.repo

import androidx.lifecycle.LiveData
import com.hc.login.net.LoginReqBody
import com.hc.login.net.LoginRsp
import com.hc.login.net.RegisterRsp

/**
 *
 * @author:        Created by hc
 * @date:          Create in 15:49 2021/8/1
 * @description:
 *
 */

/*
* 登录模块相关的抽象数据接口
* */
interface ILoginResource {

    /*
    * 校验手机号是否注册、合法
    * */
    suspend fun checkRegister(mobi: String)

    /*
    * 手机号合法的基础上，调用登录，获取登录结果token
    * */
    suspend fun requestLogin(body: LoginReqBody)

    //注册与否的检查结果
    val registerRsp: LiveData<RegisterRsp>

    //登录成功后的结果
    val loginRsp: LiveData<LoginRsp>

}