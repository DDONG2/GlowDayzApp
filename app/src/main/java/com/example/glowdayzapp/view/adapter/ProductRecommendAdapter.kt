package com.example.glowdayzapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.glowdayzapp.databinding.ItemHorizontalProductBinding
import com.example.glowdayzapp.model.vo.*
import com.example.glowdayzapp.view.viewholder.ProductHorizontalItemViewHolder

class ProductRecommendAdapter(private val HorizontalItemClickListener: (product: RecommendProductVO) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private  var recommendproductsList :List<RecommendProductVO> = listOf<RecommendProductVO>()


    fun setRecommendProductList(recommendProductList: List<RecommendProductVO>) {
        this.recommendproductsList = recommendProductList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemHorizontalProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductHorizontalItemViewHolder(binding.root, parent.context, HorizontalItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductHorizontalItemViewHolder)
            holder.bind(recommendproductsList.get(position))
    }

    override fun getItemCount(): Int {
        return recommendproductsList.size
    }


}