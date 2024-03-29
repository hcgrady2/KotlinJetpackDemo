package com.hc.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hc.common.webview.WebViewActivity
import com.hc.home.databinding.ItemJobClassBinding
import com.hc.home.net.JobClassList

/**
 *
 * @author:        Created by hc
 * @date:          Create in 22:58 2021/8/14
 * @description:
 *
 */
/*
* 就业班适配器
* */
class JobClassAdapter(private val jobClassList: JobClassList) : RecyclerView.Adapter<JobClassAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH.create(parent)

    override fun onBindViewHolder(holder: JobClassAdapter.VH, position: Int) {
        holder.bind(jobClassList[position])
    }

    override fun getItemCount() = jobClassList.size


    class VH(private val binding: ItemJobClassBinding): RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(parent: ViewGroup): VH {
                val itemBinding =
                    ItemJobClassBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return VH(itemBinding)
            }
        }

        fun bind(info: JobClassList.JobClassListItem) {
            binding.url = info.course?.imgUrl //把图片和data binding的url绑定
            itemView.setOnClickListener { //itemView点击事件
                // ToastUtils.showShort("点击事件")
                WebViewActivity.openUrl(it.context, "https://www.cniao5.com/course/10201")
            }
            binding.executePendingBindings()
        }
    }
}