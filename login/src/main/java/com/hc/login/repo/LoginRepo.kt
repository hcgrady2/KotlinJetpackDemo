package com.hc.login.repo

import androidx.lifecycle.LiveData
import com.blankj.utilcode.util.LogUtils
import com.hc.common.model.SingleLiveData
import com.hc.common.network.support.serverData
import com.hc.login.net.LoginReqBody
import com.hc.login.net.LoginRsp
import com.hc.login.net.LoginService
import com.hc.login.net.RegisterRsp
import com.hc.service.net.onBizError
import com.hc.service.net.onBizOK
import com.hc.service.net.onFailure
import com.hc.service.net.onSuccess


/*
* 数据管理类的实现
* */

class LoginRepo(private val service: LoginService) : ILoginResource{

    //内部私有 可以赋值
    private val _registerRsp = SingleLiveData<RegisterRsp>()
    private val _loginRsp = SingleLiveData<LoginRsp>()

    //对外公开,只能观察 不可赋值get put value的
    override val registerRsp: LiveData<RegisterRsp> = _registerRsp
    override val loginRsp: LiveData<LoginRsp> = _loginRsp

    //校验是否注册 网络请求
    override suspend fun checkRegister(mobi: String) {

        //LogUtils.e("是否注册 接口异常 ${i}")

        service.isRegister(mobi)
            .serverData()
            .onSuccess {
                onBizError { code, message ->
                    LogUtils.w("是否注册 BizError $code,$message")
                }
                onBizOK<RegisterRsp> { code, data, message ->
                    _registerRsp.value = data
                    // LogUtils.i("是否注册 BizOK $data")
                    return@onBizOK
                }
            }
            .onFailure {
                LogUtils.e("是否注册 接口异常 ${it.message}")
            }
    }

    //登录 网络请求
    override suspend fun requestLogin(body: LoginReqBody) {
        service.login(body)
            .serverData()
            .onSuccess { //接口请求成功
                onBizError { code, message ->
                    LogUtils.w("登录接口 BizError $code,$message")
                }
                onBizOK<LoginRsp> { code, data, message ->
                    _loginRsp.value = data
                    //同步到room数据库 登录状态
                    // LogUtils.i("登录接口 BizOK $data")
                    return@onBizOK
                }
            }
            .onFailure {
                LogUtils.e("登录接口 接口异常 ${it.message}")
            }
    }

}