package com.hc.study.ui

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.hc.study.net.StudiedRsp

/**
 *
 * @author:        Created by hc
 * @date:          Create in 16:18 2021/8/21
 * @description:
 *
 */
/*
* 列表适配器 RecyclerView.ViewHolder用作其视图支架类型
* paging3 分页库 用于加载本地/网络数据显示
* */
class StudyPageAdapter : PagingDataAdapter<StudiedRsp.Data, StudiedVH>(differCallback) {

    override fun onBindViewHolder(holder: StudiedVH, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StudiedVH.createVH(parent)

    //用于区分是不是相同的数据
    companion object {
        private val differCallback = object : DiffUtil.ItemCallback<StudiedRsp.Data>() {

            //是否是一样的 item
            override fun areItemsTheSame(
                oldItem: StudiedRsp.Data,
                newItem: StudiedRsp.Data
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: StudiedRsp.Data,
                newItem: StudiedRsp.Data
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}