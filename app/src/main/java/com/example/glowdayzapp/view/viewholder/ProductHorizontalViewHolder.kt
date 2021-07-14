package com.example.glowdayzapp.view.viewholder

import android.content.Context
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.glowdayzapp.databinding.HorizontalProductContainerBinding
import com.example.glowdayzapp.model.vo.ProductResponse

class ProductHorizontalViewHolder (itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {

    private var binding: HorizontalProductContainerBinding

    init {
        binding = DataBindingUtil.bind(itemView)!!
    }


    fun bind(item: ProductResponse) {

    }

}