package com.hc.home.ui.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hc.common.webview.WebViewActivity
import com.hc.home.databinding.ItemHomeCourseBinding
import com.hc.home.net.HomeCourseItem

/**
 *
 * @author:        Created by hc
 * @date:          Create in 22:57 2021/8/14
 * @description:
 *
 */
/*
* 新上好课/实战推荐适配器
* */
class HomeCourseAdapter(private val mList: List<HomeCourseItem>) : RecyclerView.Adapter<HomeCourseAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH.create(parent)

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount() = mList.size


    class VH(private val binding: ItemHomeCourseBinding): RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(parent: ViewGroup): VH {
                val itemBinding =
                    ItemHomeCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return VH(itemBinding)
            }
        }

        fun bind(info: HomeCourseItem) {
            binding.info = info
            binding.tvOldPriceItemCourse.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG //中划线
            itemView.setOnClickListener { //todo图片点击事件
                // ToastUtils.showShort("点击事件")
                WebViewActivity.openUrl(it.context, "https://www.cniao5.com/course/10201")
            }
            binding.executePendingBindings()
        }
    }
}