package com.example.glowdayzapp.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.glowdayzapp.BaseFragment
import com.example.glowdayzapp.R
import com.example.glowdayzapp.databinding.FragmentHomeBinding
import com.example.glowdayzapp.view.adapter.ProductRecyclerAdapter
import com.example.glowdayzapp.viewmodel.MainViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, MainViewModel>() {

    override val viewModel: MainViewModel
        get() = ViewModelProvider(this).get(MainViewModel::class.java)


    override val layoutId: Int
        get() = R.layout.fragment_home

    private lateinit var mainAdapter: ProductRecyclerAdapter

    override fun createObserveData() {
        viewModel.ProductLiveData.observe(this, Observer {

            mainAdapter.setProductList(it)

            dataBinding.recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = mainAdapter
            }

            dataBinding.loadingProgressBar.visibility = View.GONE


        })

        viewModel.ErrorMessage.observe(this, {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            dataBinding.loadingProgressBar.visibility = View.GONE

        })
    }

    override fun initView() {

        dataBinding.loadingProgressBar.visibility = View.VISIBLE

        mainAdapter = ProductRecyclerAdapter()

        viewModel.getProductInfo()
    }

    override fun initArgument(bundle: Bundle) {

    }


    companion object {

        fun newInstance() = HomeFragment()

    }
}