package com.example.glowdayzapp.view.viewholder

import android.content.Context
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.glowdayzapp.databinding.HorizontalProductContainerBinding
import com.example.glowdayzapp.model.vo.ProductRecommResponse
import com.example.glowdayzapp.model.vo.ProductResponse
import com.example.glowdayzapp.model.vo.ProductVO
import com.example.glowdayzapp.model.vo.RecommendProductVO
import com.example.glowdayzapp.view.adapter.ProductRecommendAdapter
import com.example.glowdayzapp.view.adapter.ProductRecyclerAdapter

class ProductHorizontalViewHolder (itemView: View, private val context: Context, private val HorizontalItemClickListener: (product: ProductVO) -> Unit) : RecyclerView.ViewHolder(itemView) {

    private var binding: HorizontalProductContainerBinding

    init {
        binding = DataBindingUtil.bind(itemView)!!
    }

    private lateinit var RecommendAdapter: ProductRecommendAdapter


    fun bind(item: ProductRecommResponse) {

        RecommendAdapter = ProductRecommendAdapter(HorizontalItemClickListener)
        RecommendAdapter.setRecommendProductList(item)

        item?.let{
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(context).also { it.orientation = LinearLayoutManager.HORIZONTAL }
                adapter = RecommendAdapter
            }
        }




    }

}