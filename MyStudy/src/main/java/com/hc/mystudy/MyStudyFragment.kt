package com.hc.mystudy

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.google.android.material.tabs.TabLayout
import com.hc.common.base.BaseFragment
import com.hc.mystudy.databinding.FragmentMystudyMainBinding

/**
 * @Author: wanghaichao
 * @Date: 2023/4/20
 * @Description:
 * @Copyright: all rights reserved.
 */
class MyStudyFragment:BaseFragment() {
    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
        return FragmentMystudyMainBinding.bind(view)
    }

    override fun getLayoutRes() = R.layout.fragment_mystudy_main
}