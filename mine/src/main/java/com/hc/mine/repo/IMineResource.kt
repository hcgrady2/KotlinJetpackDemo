package com.hc.mine.repo

import androidx.lifecycle.LiveData
import com.hc.mine.net.UserInfoRsp

/**
 *
 * @author:        Created by hc
 * @date:          Create in 22:33 2021/8/14
 * @description:
 *
 */


/*
* Mine模块的数据获取 接口
* */
interface IMineResource {

    //用户信息的返回数据类 livedata
    val liveUserInfo: LiveData<UserInfoRsp>

    //获取userinfo的api函数
    suspend fun getUserInfo(token: String?)

}