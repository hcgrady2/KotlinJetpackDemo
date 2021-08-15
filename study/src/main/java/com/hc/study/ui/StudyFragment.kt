package com.hc.study.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.hc.common.base.BaseFragment
import com.hc.study.R

/**
 * Created by hcw  on 2021/7/10
 * 类描述：
 * all rights reserved
 */
class StudyFragment : BaseFragment() {
    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
        TODO("Not yet implemented")
    }


    //传入布局资源,将布局和view绑定到一起
    override fun getLayoutRes() = R.layout.fragment_study
}