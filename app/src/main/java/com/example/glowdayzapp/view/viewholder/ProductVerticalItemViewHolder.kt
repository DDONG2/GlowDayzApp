package com.example.glowdayzapp.view.viewholder

import android.content.Context
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.glowdayzapp.R
import com.example.glowdayzapp.databinding.ItemVerticalProductBinding
import com.example.glowdayzapp.model.vo.ProductAllList
import com.example.glowdayzapp.model.vo.ProductVO

class ProductVerticalItemViewHolder (itemView: View, private val context: Context, private val VerticalItemClickListener: (product: ProductVO) -> Unit) : RecyclerView.ViewHolder(itemView) {

    private var binding: ItemVerticalProductBinding

    init {
        binding = DataBindingUtil.bind(itemView)!!
    }


    fun bind(item: ProductAllList) {

        item.products?.imageUrl?.let{
            Glide.with(context)
                .load(it)
                .error(R.drawable.ic_launcher_background)
                .into(binding.productImage)
        }

        item.products?.productRank?.let{
            binding.productNumber.text = it
        }

        item.products?.brand?.brandTitle?.let {
            binding.brandTitle.text = it
        }

        item.products?.productTitle?.let {
            binding.productTitle.text = it
        }

        item.products?.ratingAvg?.let {
            binding.ratingAvg.text = it.toString()
        }

        item.products?.reviewCount?.let {
            binding.reviewCount.text = "(리뷰 " + it + ")"
        }
        binding.fullLayout.setOnClickListener{
            item.products?.let { it -> VerticalItemClickListener(it) }
        }





    }

}