package com.example.glowdayzapp.view.viewholder

import android.content.Context
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.glowdayzapp.databinding.ItemHorizontalProductBinding
import com.example.glowdayzapp.databinding.ItemVerticalProductBinding
import com.example.glowdayzapp.model.vo.ProductRecommResponse
import com.example.glowdayzapp.model.vo.ProductResponse
import com.example.glowdayzapp.model.vo.ProductVO

class ProductHorizontalItemViewHolder (itemView: View, private val context: Context, private val HorizontalItemClickListener: (product: ProductVO) -> Unit) : RecyclerView.ViewHolder(itemView) {

    private var binding: ItemHorizontalProductBinding

    init {
        binding = DataBindingUtil.bind(itemView)!!
    }


    fun bind(item: ProductRecommResponse) {
        item.recommend1.get(0).imageUrl?.let{
            Glide.with(context)
                .load(it)
                .into(binding.productImage)
        }

    }

}