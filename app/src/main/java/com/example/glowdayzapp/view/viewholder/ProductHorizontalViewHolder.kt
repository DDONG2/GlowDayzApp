package com.example.glowdayzapp.view.viewholder

import android.content.Context
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.glowdayzapp.databinding.HorizontalProductContainerBinding
import com.example.glowdayzapp.model.vo.*
import com.example.glowdayzapp.view.adapter.ProductRecommendAdapter

class ProductHorizontalViewHolder (itemView: View, private val context: Context, private val HorizontalItemClickListener: (product: RecommendProductVO) -> Unit) : RecyclerView.ViewHolder(itemView) {

    private var binding: HorizontalProductContainerBinding


    init {
        binding = DataBindingUtil.bind(itemView)!!
    }

    private lateinit var RecommendAdapter: ProductRecommendAdapter


    fun bind(item: ProductAllList) {

        RecommendAdapter = ProductRecommendAdapter(HorizontalItemClickListener)

        item.recommend?.let {
            RecommendAdapter.setRecommendProductList(it)
        }

        item?.let{
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(context).also { it.orientation = LinearLayoutManager.HORIZONTAL }
                adapter = RecommendAdapter
            }
        }

    }

}