package com.hc.mine.ui

import android.os.Bundle
import android.view.View
import com.hc.common.base.BaseFragment
import com.hc.mine.R
import com.hc.mine.databinding.FragmentContainerMineBinding

/**
 * Created by hcw  on 2021/7/10
 * 类描述：
 * all rights reserved
 */

/*
* Mine模块的主Fragment，用于内部navigation的容器
* */
class MineContainerFragment: BaseFragment(){

    override fun getLayoutRes() = R.layout.fragment_container_mine

    override fun bindView(view: View, savedInstanceState: Bundle?) = FragmentContainerMineBinding.bind(view)

}