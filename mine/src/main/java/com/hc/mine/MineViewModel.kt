package com.hc.mine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hc.common.base.BaseViewModel
import com.hc.mine.net.UserInfoRsp
import com.hc.mine.repo.IMineResource

/**
 *
 * @author:        Created by hc
 * @date:          Create in 22:31 2021/8/14
 * @description:
 *
 */

/*
* Mine模块的viewModel
* */
class MineViewModel(private val repo: IMineResource): BaseViewModel() {

    //UserInfo的数据
    // val liveUser = MutableLiveData<UserInfo>()

    //用在userInfoRspFragment中
    val liveInforep: LiveData<UserInfoRsp> = repo.liveUserInfo

    //用于布局的Livedata
    val liveInfoRsp = MutableLiveData<UserInfoRsp>()

    /*
    * 获取用户信息
    * */
    fun getUserInfo(token: String?) {
        serverAwait {
            repo.getUserInfo(token)
        }
    }


}