package com.hc.kotlinjetpackdemo.ui.topheadline

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hc.common.base.BaseFragment
import com.hc.kotlinjetpackdemo.MyApplication
import com.hc.kotlinjetpackdemo.R
import com.hc.kotlinjetpackdemo.data.model.Article
import com.hc.kotlinjetpackdemo.databinding.FragmentMystudyMainBinding
import com.hc.kotlinjetpackdemo.ui.base.UiState
import com.hc.study.databinding.FragmentStudyBinding
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: wanghaichao
 * @Date: 2023/4/20
 * @Description:
 * @Copyright: all rights reserved.
 */
class TopHeadlineFragment:BaseFragment() {

   // @Inject
    lateinit var topHeadlineViewModel: TopHeadlineViewModel

  //  @Inject
    lateinit var adapter: TopHeadlineAdapter

    private lateinit var binding: FragmentMystudyMainBinding


    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
        return FragmentMystudyMainBinding.bind(view)
    }

    override fun getLayoutRes() = R.layout.fragment_mystudy_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // injectDependencies()
        binding = FragmentMystudyMainBinding.inflate(layoutInflater)
        setupUI()
        setupObserver()
    }


    private fun setupUI() {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                topHeadlineViewModel.uiState.collect {
                    when (it) {
                        is UiState.Success -> {
                            binding.progressBar.visibility = View.GONE
                            renderList(it.data)
                            binding.recyclerView.visibility = View.VISIBLE
                        }
                        is UiState.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                            binding.recyclerView.visibility = View.GONE
                        }
                        is UiState.Error -> {
                            //Handle Error
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }

    private fun renderList(articleList: List<Article>) {
        adapter.addData(articleList)
        adapter.notifyDataSetChanged()
    }

//    private fun injectDependencies() {
//        DaggerActivityComponent.builder()
//            .applicationComponent((activity?.application as MyApplication).applicationComponent)
//            .activityModule(ActivityModule(activity )).build().inject(activity)
//    }

}