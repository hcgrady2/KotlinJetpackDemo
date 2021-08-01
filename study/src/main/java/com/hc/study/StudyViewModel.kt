package com.hc.study

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.hc.common.base.BaseViewModel
import com.hc.service.repo.UserInfo
import com.hc.study.net.BoughtRsp
import com.hc.study.net.StudiedRsp
import com.hc.study.net.StudyInfoRsp
import com.hc.study.repo.StudyResource
import com.hc.study.ui.StudiedAdapter

/**
 *
 * @author:        Created by hc
 * @date:          Create in 15:09 2021/8/1
 * @description:
 *
 */

class StudyViewModel(private val resource: StudyResource) : BaseViewModel() {

    //用户学习详情
    val liveStudyInfo: LiveData<StudyInfoRsp> = resource.liveStudyInfo //这个数据用来观察
    val liveStudyInfoR = MutableLiveData<StudyInfoRsp>() //这个是界面布局数据
    //已经学习过的课程列表
    val liveStudyList: LiveData<StudiedRsp> = resource.liveStudyList
    //已经购买的课程，班级 信息
    val liveBoughtList: LiveData<BoughtRsp> = resource.liveBoughtList

    //用户信息
    val obUserInfo = ObservableField<UserInfo>()

    //我的学习列表适配器
    val adapter = StudiedAdapter()
    //我的学习列表适配器 paging3 由于返回数据固定的原因，total_page一直为2，会报错IllegalStateException
    // val adapterPaging = StudyPageAdapter()

    //请求数据
    fun getStudyData() = serverAwait {
        resource.getStudyInfo()
        resource.getStudyList()
        // resource.getBoughtCourse()
    }

    suspend fun pagingData() = resource.pagingData().asLiveData()


}