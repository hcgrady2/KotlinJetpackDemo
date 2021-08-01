package com.hc.study.repo

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.hc.study.net.BoughtRsp
import com.hc.study.net.StudiedRsp
import com.hc.study.net.StudyInfoRsp
import kotlinx.coroutines.flow.Flow

/**
 *
 * @author:        Created by hc
 * @date:          Create in 15:02 2021/8/1
 * @description:
 *
 */
/*
* 学习中心模块相关的抽象数据接口
* */
interface IStudyResource {

    val liveStudyInfo: LiveData<StudyInfoRsp>
    val liveStudyList: LiveData<StudiedRsp>
    val liveBoughtList: LiveData<BoughtRsp>

    //用户学习详情
    suspend fun getStudyInfo()

    //用户学习过的课程列表
    suspend fun getStudyList()

    //用户购买的课程
    suspend fun getBoughtCourse()

    /*
    * 将studyPageSource转化为flow数据
    * */
    suspend fun pagingData(): Flow<PagingData<StudiedRsp.Data>>

}