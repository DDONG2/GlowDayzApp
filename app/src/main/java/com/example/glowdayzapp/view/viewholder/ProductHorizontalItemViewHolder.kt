package com.example.glowdayzapp.view.viewholder

import android.content.Context
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.glowdayzapp.databinding.ItemHorizontalProductBinding
import com.example.glowdayzapp.model.vo.*

class ProductHorizontalItemViewHolder (itemView: View, private val context: Context, private val HorizontalItemClickListener: (product: RecommendProductVO) -> Unit) : RecyclerView.ViewHolder(itemView) {

    private var binding: ItemHorizontalProductBinding

    init {
        binding = DataBindingUtil.bind(itemView)!!
    }


    fun bind(item: RecommendProductVO) {
        item.imageUrl?.let{
            Glide.with(context)
                .load(it)
                .into(binding.productImageRecommend)
        }

        item.productTitle?.let{
            binding.productTitleRecommend.text = it
        }

        item.ratingAvg?.let {
            binding.ratingAvgRecommend.text = it.toString()
        }

        item.reviewCount?.let {
            binding.reviewCountRecommend.text = "(리뷰 " + it + ")"
        }

        binding.fullLayoutRecommend.setOnClickListener{
            item?.let { it -> HorizontalItemClickListener(it) }
        }
    }

}