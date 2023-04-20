package com.hc.kotlinjetpackdemo.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.hc.common.base.BaseFragment
import com.hc.kotlinjetpackdemo.R
import com.hc.kotlinjetpackdemo.databinding.FragmentMystudyMainBinding
import com.hc.kotlinjetpackdemo.databinding.FragmentMystudyMainStudyBinding

/**
 * @Author: wanghaichao
 * @Date: 2023/4/20
 * @Description:
 * @Copyright: all rights reserved.
 */
class MyStudyFragment:BaseFragment() {
    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
        return FragmentMystudyMainStudyBinding.bind(view)
    }

    override fun getLayoutRes() = R.layout.fragment_mystudy_main_study
}