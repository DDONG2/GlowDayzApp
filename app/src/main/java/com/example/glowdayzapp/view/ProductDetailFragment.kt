package com.example.glowdayzapp.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.glowdayzapp.BaseFragment
import com.example.glowdayzapp.R
import com.example.glowdayzapp.databinding.FragmentHomeBinding
import com.example.glowdayzapp.databinding.FragmentProductDetailBinding
import com.example.glowdayzapp.model.vo.ProductVO
import com.example.glowdayzapp.viewmodel.MainViewModel

class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding, MainViewModel>() {

    override val viewModel: MainViewModel
        get() = ViewModelProvider(this).get(MainViewModel::class.java)


    override val layoutId: Int
        get() = R.layout.fragment_product_detail

    val args: ProductDetailFragmentArgs by navArgs()

    override fun createObserveData() {

    }

    override fun initView() {

        dataBinding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }

//        Glide.with(requireActivity())
//            .load(args.productVo.imageUrl)
//            .into(dataBinding.productImage)
//
//        dataBinding.productTitle.text = args.productVo.productTitle

    }


    override fun initArgument(bundle: Bundle) {


    }


    companion object {

        fun newInstance() = HomeFragment()

    }

    override fun initFirstData() {

    }
}