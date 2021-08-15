package com.hc.home.repo

import androidx.lifecycle.LiveData
import com.hc.common.network.model.DataResult
import com.hc.home.net.BannerList
import com.hc.home.net.HomeList
import com.hc.service.net.BaseResponse

/**
 * Created by hcw  on 2021/7/10
 * 类描述：
 * all rights reserved
 */

/*
* 抽象接口
* */
interface IHomeResource {

    //首页上方banner图
    val liveBanner: LiveData<BannerList>

    suspend fun getBanner()


    //首页模块名字、请求地址列表
    val liveHomeList: LiveData<HomeList>

    suspend fun getHomeList()


    // suspend fun getModuleDatas(moduleid: Int): DataResult<BaseResponse> //返回完整的数据

    suspend fun getJobDatas(moduleid: Int): DataResult<BaseResponse> //就业班

    suspend fun getHomeCourse(courseid: Int): DataResult<BaseResponse> //课程推荐

    suspend fun getTeacherList(page: Int, size: Int):DataResult<BaseResponse> //金牌讲师



}