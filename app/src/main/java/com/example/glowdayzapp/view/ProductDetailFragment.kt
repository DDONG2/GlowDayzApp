package com.example.glowdayzapp.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.glowdayzapp.BaseFragment
import com.example.glowdayzapp.R
import com.example.glowdayzapp.databinding.FragmentHomeBinding
import com.example.glowdayzapp.viewmodel.MainViewModel

class ProductDetailFragment : BaseFragment<FragmentHomeBinding, MainViewModel>() {

    override val viewModel: MainViewModel
        get() = ViewModelProvider(this).get(MainViewModel::class.java)


    override val layoutId: Int
        get() = R.layout.fragment_product_detail

    override fun createObserveData() {

    }

    override fun initView() {

    }

    override fun initArgument(bundle: Bundle) {

    }


    companion object {

        fun newInstance() = HomeFragment()

    }
}