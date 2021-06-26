package com.hc.common.ktx;

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.core.app.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner

/**
 *
 * Activity相关的Ktx ，扩展函数和扩展属性
 * */
fun <T:ViewDataBinding> Activity.bindView(@LayoutRes layout: Int):T{
    return DataBindingUtil.setContentView(this,layout)
}

/**
 * 返回可空
 */
fun <T:ViewDataBinding> Activity.bindView(view:View):T?{
    return DataBindingUtil.bind<T>(view)
}

/**
 * 状态栏和软键盘，状态栏需要在 setContentView 之前调用才生效
 */
fun  Activity.immediateStatusBar(){
    window.apply {
        addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
        addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
}


fun Activity.dismissKeyBoard(view:View){
    val imm:InputMethodManager ? = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager?

    imm?.hideSoftInputFromWindow(view.windowToken,0)

}



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


