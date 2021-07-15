package com.example.glowdayzapp.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    private var pageNumber: Int = 1

    override fun createObserveData() {
        viewModel.ProductLiveData.observe(this, Observer {

            mainAdapter.setProductList(it)

            dataBinding.recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = mainAdapter
            }

            dataBinding.loadingProgressBar.visibility = View.GONE


        })

        viewModel.MoreProductLiveData.observe(this, Observer {

            mainAdapter.setProductList(it)
            mainAdapter.notifyDataSetChanged()

            dataBinding.loadingProgressBar.visibility = View.GONE


        })


        viewModel.ErrorMessage.observe(this, {
            Toast.makeText(requireContext(), "더 이상 불러올 목록이 없습니다.", Toast.LENGTH_SHORT).show()
            Log.d("Error", it)
            dataBinding.loadingProgressBar.visibility = View.GONE

        })
    }

    override fun initView() {

        dataBinding.loadingProgressBar.visibility = View.VISIBLE

        mainAdapter = ProductRecyclerAdapter()

        dataBinding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val lastVisibleItemPosition = (recyclerView.layoutManager as LinearLayoutManager?)!!.findLastCompletelyVisibleItemPosition()
                val itemTotalCount = recyclerView.adapter!!.itemCount-1
                // 스크롤이 끝에 도달했는지 확인
                if (!dataBinding.recyclerView.canScrollVertically(1) && lastVisibleItemPosition == itemTotalCount) {

                    dataBinding.loadingProgressBar.visibility = View.VISIBLE

                    pageNumber++

                    viewModel.getMoreProductInfo(pageNumber)

                }
            }
        })

        viewModel.getProductInfo(pageNumber)


    }

    override fun initArgument(bundle: Bundle) {

    }


    companion object {

        fun newInstance() = HomeFragment()

    }
}