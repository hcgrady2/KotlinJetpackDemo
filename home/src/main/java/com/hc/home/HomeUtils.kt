package com.hc.home

import com.hc.home.net.HomeCourseItem

/**
 *
 * @author:        Created by hc
 * @date:          Create in 22:29 2021/8/14
 * @description:
 *
 */

/*
 */
object HomeUtils {

    @JvmStatic
    fun parseStudentComment(info: HomeCourseItem?): String {
        return "${info?.lessonsCount} ${info?.commentCount}人评价"
    }

    /*
    * 是否免费 免费返回true 否则返回false
    * */
    @JvmStatic
    fun parseFree(info: HomeCourseItem?): Boolean {
        return info?.isFree == 1
    }

}