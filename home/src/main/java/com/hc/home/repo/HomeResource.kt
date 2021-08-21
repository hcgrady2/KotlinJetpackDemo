package com.hc.home.repo

/**
 *
 * @author:        Created by hc
 * @date:          Create in 15:54 2021/8/21
 * @description:
 *
 */
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.LogUtils
import com.hc.common.network.model.DataResult
import com.hc.common.network.support.serverData
import com.hc.home.net.BannerList
import com.hc.home.net.HomeList

import com.hc.home.net.HomeService
import com.hc.service.net.*
import kotlin.onFailure


class HomeResource(val service: HomeService) : IHomeResource {


    /*
    * 获取首页上方banner图数据
    * */
    private val _liveBanner = MutableLiveData<BannerList>()

    override val liveBanner: LiveData<BannerList>
        get() = _liveBanner

    override suspend fun getBanner() {
        service.getBanner()
            .serverData()
            .onSuccess {
                onBizError { code, message ->
                    LogUtils.w("获取banner信息 onBizzError $code$message")
                }
                onBizOK<BannerList> { code, data, message ->
                    _liveBanner.value = data
                    LogUtils.i("获取banner信息 onBizzOK $data")
                }
            }
            .onFailure {
                LogUtils.e("获取banner信息 接口异常 ${it.message}")
            }
    }


    /*
    * 首页模块名字、请求地址列表
    * */
    private val _liveHomeList = MutableLiveData<HomeList>()

    override val liveHomeList: LiveData<HomeList>
        get() = _liveHomeList

    override suspend fun getHomeList() {
        service.getHomeList()
            .serverData()
            .onSuccess {
                onBizError { code, message ->
                    LogUtils.w("获取首页模块列表 BizError $code,$message")
                }
                onBizOK<HomeList> { code, data, message ->
                    _liveHomeList.value = data
                    LogUtils.i("获取首页模块列表 BizOK $data")
                }
            }
            .onFailure {
                LogUtils.e("获取首页模块列表 接口异常 ${it.message}")
            }
    }

    /*
    * 首页各个模块的详情内容，返回完整的数据，在fragment中解析分类
    * */
    // override suspend fun getModuleDatas(moduleid: Int) = service.getModuleDatas(moduleid).serverData()

    //就业班
    override suspend fun getJobDatas(moduleid: Int): DataResult<BaseResponse> {
        return service.getJobDatas(moduleid).serverData()
    }

    //课程推荐
    override suspend fun getHomeCourse(courseid: Int): DataResult<BaseResponse> {
        return service.getHomeCourse(courseid).serverData()
    }

    //金牌讲师
    override suspend fun getTeacherList(page: Int, size: Int): DataResult<BaseResponse> {
        return service.getTeacherList(page, size).serverData()
    }


}