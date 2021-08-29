package com.hc.service.repo

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * @author:        Created by hc
 * @date:          Create in 16:27 2021/8/29
 * @description:
 *
 */
class CniaoUserInfo {
}


@Entity(tableName = "tb_cniao_user")
data class CinaoUserInfo(
    @PrimaryKey val id:Int,
    val  course_permission:Boolean,
    val token:String?,
    @Embedded val user:User?
){

    @Keep data class User(
        @ColumnInfo (name = "cniao_user_id")
        val id:Int,
        val logo_url:String?,
        val reg_time:String?,
        val username:String?
    )
}