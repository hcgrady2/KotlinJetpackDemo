package com.hc.common.ktx;

import android.app.Activity
import android.content.Context
import androidx.core.app.ComponentActivity
import androidx.lifecycle.LifecycleOwner

/**
 *
 * Activity相关的Ktx ，扩展函数和扩展属性
 * */





/**
 * 扩展lifeCycleOwner属性，便于和Fragment之间使用lifeCycleOwner 一致性
 */
val ComponentActivity.viewLifeCycleOwner: LifecycleOwner
    get() = this

/**
 * Activity的扩展字段，便于和Fragment中使用liveData之类的时候，参数一致性
 */
val Activity.context: Context
    get() = this


