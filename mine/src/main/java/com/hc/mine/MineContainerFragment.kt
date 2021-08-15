package com.hc.mine

import android.os.Bundle
import android.view.View
import com.hc.common.base.BaseFragment
import com.hc.mine.databinding.FragmentContainerMineBinding

/**
 *
 * @author:        Created by hc
 * @date:          Create in 10:36 2021/8/15
 * @description:
 *
 */
/*
* Mine模块的主Fragment，用于内部navigation的容器
* */
class MineContainerFragment: BaseFragment(){

    override fun getLayoutRes() = R.layout.fragment_container_mine

    override fun bindView(view: View, savedInstanceState: Bundle?) = FragmentContainerMineBinding.bind(view)

}