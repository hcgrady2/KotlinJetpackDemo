package com.hc.service.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.hc.service.R

/*
* 项目适配用的BindAdapter
* DataBinding扩展支持
* */

/*
* app:srcCompat的DataBinding扩展
* imageView支持图片加载 绑定
* */
@BindingAdapter("srcCompat", requireAll = false)
fun imgSrcCompat(iv: ImageView, src: Any?) {
    //如果src为空，设置默认图片
    // val imgRes = src ?: R.drawable.icon_default_header
    //如果String头为//img.cniao5.com，则在其前面拼接上https:
    val imgRes = when(src) {
        is String -> {
            when {
                //如果开头是//img.cniao5.com就添加前缀https:
                src.startsWith("//img.cniao5.com") -> "https:$src"
                else -> src
            }
        }
        else -> src ?: R.drawable.icon_default_header
    }

    Glide.with(iv)
        .load(imgRes)
        .into(iv)
}

/**
 * 图片资源支持tint颜色修改，支持colorRes和colorInt形式
 */
@BindingAdapter("tint")
fun imgColor(iv: ImageView, color: Int) {
    if (color == 0) return
    runCatching {
        iv.setColorFilter(iv.resources.getColor(color))
    }.onFailure {//捕获异常，说明此时是Color.RED形式 colorInt
        iv.setColorFilter(color)
    }
}

/**
 * textColor的binding形式，支持colorRes和colorInt形式
 */
@BindingAdapter("android:textColor")
fun tvColor(tv: TextView, color: Int) {
    if (color == 0) return
    runCatching {
        //如果是colorInt形式，会报错
        tv.setTextColor(tv.resources.getColor(color))
    }.onFailure {//捕获异常，说明此时是Color.RED形式
        tv.setTextColor(color)
    }
}

/*
* //todo 进度条，NumberProgressBar的扩展函数 将传来的progress*100转化为百分比形式 并且支持databinding加载
* */
// @BindingAdapter("app:progress_current", requireAll = false)
// fun setProgress(pb: NumberProgressBar, progress: Double?) {
//     pb.progress = ((progress ?: 0.0) * 100).toInt() //*100，转化为百分比显示
// }

