package com.hc.home.ui.adapter

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.hc.common.webview.WebViewActivity
import com.hc.home.R
import com.hc.home.net.BannerList
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder

/**
 *
 * @author:        Created by hc
 * @date:          Create in 22:45 2021/8/14
 * @description:
 *
 */
/*
* 首页上方banner的适配器,传入bannerList解析的数据格式
* */
class BannerAdapter(private val bannerList: BannerList) : BannerImageAdapter<BannerList.BannerListItem>(bannerList) {
    override fun onBindView(
        holder: BannerImageHolder?,
        data: BannerList.BannerListItem?,
        position: Int,
        size: Int
    ) {
        holder ?: return //如果为空的话直接返回

        //有的相片地址没有https:
        val src = data?.imgUrl
        val imageUrl = when(src) {
            is String -> {
                when {
                    src.startsWith("//img.cniao5.com") -> "https:$src"
                    else -> src
                }
            }
            else -> src ?: R.drawable.img_course
        }

        //不为空时加载图片
        Glide.with(holder.itemView)
            .load(imageUrl)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
            .into(holder.imageView)

        //todo 添加holder.itview的点击事件,打开data.redirectUrl
        holder.itemView.setOnClickListener {
            // ToastUtils.showShort("${data?.redirectUrl}")
            WebViewActivity.openUrl(it.context, data?.redirectUrl ?: "https://m.cniao5.com/")
        }
    }
}