package com.example.glowdayzapp.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.glowdayzapp.BaseActivity
import com.example.glowdayzapp.R
import com.example.glowdayzapp.databinding.ActivityMainBinding
import com.example.glowdayzapp.view.adapter.ProductRecyclerAdapter
import com.example.glowdayzapp.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private lateinit var mainAdapter: ProductRecyclerAdapter

    override val viewModel: MainViewModel
        get() = ViewModelProvider(this).get(MainViewModel::class.java)

    override val layoutId: Int
        get() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding.loadingProgressBar.visibility = View.VISIBLE

        mainAdapter = ProductRecyclerAdapter()


        dataBinding.lifecycleOwner = this

        viewModel.getProductInfo()

    }

    override fun createObserveData() {
        viewModel.ProductLiveData.observe(this, Observer{

            mainAdapter.setProductList(it)

            dataBinding.recyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = mainAdapter
            }

            dataBinding.loadingProgressBar.visibility = View.GONE


        })

        viewModel.ErrorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            dataBinding.loadingProgressBar.visibility = View.GONE

        })


    }
}