package com.hc.course.utils

import com.hc.course.net.CourseListRsp

/**
 *
 * @author:        Created by hc
 * @date:          Create in 14:41 2021/8/1
 * @description:
 *
 */
object CourseUtils {

    /*
    * 总课时 + 评价人数
    * */
    @JvmStatic
    fun parseStudentComment(info: CourseListRsp.Data?): String {
        return "${info?.lessonsCount}  ${info?.commentCount}人评价"
    }

    /*
    * 是否免费 免费返回true 否则返回false
    * */
    @JvmStatic
    fun parseFree(info: CourseListRsp.Data?): Boolean {
        return info?.isFree == 1
    }
}