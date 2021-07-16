package com.example.glowdayzapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.glowdayzapp.databinding.HorizontalProductContainerBinding
import com.example.glowdayzapp.databinding.ItemHorizontalProductBinding
import com.example.glowdayzapp.databinding.ItemVerticalProductBinding
import com.example.glowdayzapp.model.vo.*
import com.example.glowdayzapp.view.viewholder.ProductHorizontalItemViewHolder
import com.example.glowdayzapp.view.viewholder.ProductHorizontalViewHolder
import com.example.glowdayzapp.view.viewholder.ProductVerticalItemViewHolder

class ProductRecommendAdapter(private val HorizontalItemClickListener: (product: ProductVO) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private lateinit var recommendproductsList: ProductRecommResponse


    fun setRecommendProductList(recommendProductList: ProductRecommResponse) {
        this.recommendproductsList = recommendProductList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemHorizontalProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductHorizontalItemViewHolder(binding.root, parent.context, HorizontalItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductHorizontalItemViewHolder)
            holder.bind(recommendproductsList)
    }

    override fun getItemCount(): Int {
        return recommendproductsList.recommend1.size
    }


}