package com.hc.kotlinjetpackdemo.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.databinding.ViewDataBinding
import com.hc.common.base.BaseFragment
import com.hc.kotlinjetpackdemo.R
import com.hc.kotlinjetpackdemo.databinding.FragmentMystudyMainBinding
import com.hc.kotlinjetpackdemo.databinding.FragmentMystudyMainStudyBinding
import com.hc.kotlinjetpackdemo.ui.retrofit.RetrofitMainActivity

/**
 * @Author: wanghaichao
 * @Date: 2023/4/20
 * @Description:
 * @Copyright: all rights reserved.
 */
class MyStudyFragment:BaseFragment() {
    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
        return FragmentMystudyMainStudyBinding.bind(view).apply {
            btnRetrofitDemo.setOnClickListener {
                startActivity(Intent(context,RetrofitMainActivity::class.java))
            }
        }
    }

    override fun getLayoutRes() = R.layout.fragment_mystudy_main_study


    override fun initData() {
        super.initData()
    }
}