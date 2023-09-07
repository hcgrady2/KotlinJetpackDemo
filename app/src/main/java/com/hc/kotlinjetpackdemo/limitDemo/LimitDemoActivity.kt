package com.hc.kotlinjetpackdemo.limitDemo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hc.kotlinjetpackdemo.R
import com.hc.kotlinjetpackdemo.data.api.ApiHelper
import com.hc.kotlinjetpackdemo.data.api.RetrofitBuilder
import com.hc.kotlinjetpackdemo.data.beijingLimit.LimitApiHelper
import com.hc.kotlinjetpackdemo.data.beijingLimit.LimitCameraNetBuilder
import com.hc.kotlinjetpackdemo.ui.main.RetrofitLimitViewModel
import com.hc.kotlinjetpackdemo.ui.main.RetrofitMainViewModel
import com.hc.kotlinjetpackdemo.ui.retrofit.RetrofitViewModelFactory
import com.hc.kotlinjetpackdemo.utils.Status

/**
 * @Author: wanghaichao
 * @Date: 2023/9/7
 * @Description:
 * @Copyright: all rights reserved.
 */
class LimitDemoActivity:AppCompatActivity() {
    private lateinit var viewModel: RetrofitLimitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.limit_main_demo)

        viewModel = ViewModelProviders.of(
            this,
            LimitRetrofitViewModelFactory(LimitApiHelper(LimitCameraNetBuilder.apiService))
        ).get(RetrofitLimitViewModel::class.java)

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.getAllData().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        Log.i("whcTag", "setupObservers: success")
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        Toast.makeText(this, "loaing", Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    }


}