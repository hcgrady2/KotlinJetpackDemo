package com.hc.mine.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.LogUtils
import com.hc.common.network.support.serverData
import com.hc.mine.net.MineService
import com.hc.mine.net.UserInfoRsp
import com.hc.service.net.onBizError
import com.hc.service.net.onBizOK
import com.hc.service.net.onFailure
import com.hc.service.net.onSuccess

/**
 *
 * @author:        Created by hc
 * @date:          Create in 22:33 2021/8/14
 * @description:
 *
 */

/*
* 获取用户个人信息 实际的数据获取类
* */
class MineRepo(private val service: MineService) :IMineResource{

    private val _userInfoRsp = MutableLiveData<UserInfoRsp>()

    override val liveUserInfo: LiveData<UserInfoRsp> = _userInfoRsp

    override suspend fun getUserInfo(token: String?) {
        service.getUserInfo(token)
            .serverData()
            .onSuccess {
                //只要不是接口响应成功
                onBizError { code, message ->
                    LogUtils.w("获取用户信息 BizError $code,$message")
                }
                onBizOK<UserInfoRsp> { code, data, message ->
                    _userInfoRsp.value = data
                    // LogUtils.i("获取用户信息 BizOK $data")
                    return@onBizOK
                }
            }
            .onFailure {
                LogUtils.e("获取用户信息 接口异常 ${it.message}")
            }
    }
}