package com.hc.course

/**
 *
 * @author:        Created by hc
 * @date:          Create in 14:50 2021/8/1
 * @description:
 *
 */

import androidx.lifecycle.ViewModel
import com.hc.common.base.BaseViewModel
import com.hc.course.net.CourseDetails
import com.hc.course.repo.ICourseResource

class PlayVideoViewModel(val service: ICourseResource): BaseViewModel() {

    val liveCourseDetails = service.liveCourseDetails

    fun getCourseDetails(course_id: Int) = serverAwait {
        service.getCourseDetails(course_id)
    }

    var arrayLiveCourseDetails = ArrayList<CourseDetails.CourseDetailsItem?>()


}