package com.example.glowdayzapp.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.glowdayzapp.BaseFragment
import com.example.glowdayzapp.R
import com.example.glowdayzapp.databinding.FragmentProductDetailBinding
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

        if (args.productRecommendVO == null && args.productVO != null) {
            Glide.with(requireActivity())
                .load(args.productVO?.imageUrl)
                .error(R.drawable.ic_launcher_background)
                .into(dataBinding.productImage)

            dataBinding.productTitle.text = args.productVO?.productTitle
        } else if (args.productRecommendVO != null && args.productVO == null) {
            Glide.with(requireActivity())
                .load(args.productRecommendVO?.imageUrl)
                .error(R.drawable.ic_launcher_background)
                .into(dataBinding.productImage)

            dataBinding.productTitle.text = args.productRecommendVO?.productTitle
        }


    }


    override fun initArgument(bundle: Bundle) {


    }


    companion object {

        fun newInstance() = HomeFragment()

    }

    override fun initFirstData() {

    }
}