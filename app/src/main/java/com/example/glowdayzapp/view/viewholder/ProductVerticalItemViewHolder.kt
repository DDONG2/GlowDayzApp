package com.example.glowdayzapp.view.viewholder

import android.content.Context
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.glowdayzapp.databinding.ItemVerticalProductBinding
import com.example.glowdayzapp.model.vo.ProductVO

class ProductVerticalItemViewHolder (itemView: View, private val context: Context, private val VerticalItemClickListener: (product: ProductVO) -> Unit) : RecyclerView.ViewHolder(itemView) {

    private var binding: ItemVerticalProductBinding

    init {
        binding = DataBindingUtil.bind(itemView)!!
    }


    fun bind(item: ProductVO) {

        item.imageUrl?.let{
            Glide.with(context)
                .load(it)
                .into(binding.productImage)
        }

        item.productRank?.let{
            binding.productNumber.text = it
        }

        item.brand.brandTitle?.let {
            binding.brandTitle.text = it
        }

        item.productTitle?.let {
            binding.productTitle.text = it
        }

        item.ratingAvg?.let {
            binding.ratingAvg.text = it.toString()
        }

        item.reviewCount?.let {
            binding.reviewCount.text = "(리뷰 " + it + ")"
        }
        binding.fullLayout.setOnClickListener{
            VerticalItemClickListener(item)
        }





    }

}