package com.hc.study.repo

/**
 *
 * @author:        Created by hc
 * @date:          Create in 15:02 2021/8/1
 * @description:
 *
 */


/*
* 已经学习过的课程列表数据库
* */
// object StudiedRspDBHelper {
//     /**
//      * 以普通数据对象的形式，获取数据
//      */
//     fun getStudiedRsp(context: Context) = StudiedRspDB.getInstance(context).studiedDao().queryStudied()
//
//     /**
//      * 获取room数据表中存储的数据
//      * return liveData形式
//      */
//     fun getLiveStudiedRsp(context: Context) = StudiedRspDB.getInstance(context).studiedDao().queryStudiedLiveData()
//
//     /**
//      * 删除数据表中的信息
//      */
//     fun deleteStudiedRsp(context: Context) {
//         GlobalScope.launch(Dispatchers.IO) {
//             getStudiedRsp(context)?.apply {
//                 StudiedRspDB.getInstance(context).studiedDao().deleteStudied(this)
//             }
//         }
//     }
//
//     /**
//      * 新增用户数据到数据表
//      */
//     fun insertStudiedRsp(context: Context, studiedRsp: StudiedRsp) {
//         GlobalScope.launch(Dispatchers.IO) {
//             StudiedRspDB.getInstance(context).studiedDao().insertStudied(studiedRsp)
//         }
//     }
//
// }