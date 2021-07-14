package com.example.glowdayzapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.glowdayzapp.databinding.HorizontalProductContainerBinding
import com.example.glowdayzapp.databinding.ItemVerticalProductBinding
import com.example.glowdayzapp.model.vo.ProductListViewType
import com.example.glowdayzapp.model.vo.ProductResponse
import com.example.glowdayzapp.view.viewholder.ProductHorizontalViewHolder
import com.example.glowdayzapp.view.viewholder.ProductVerticalItemViewHolder

class ProductRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var productsList :ProductResponse


    fun setProductList(weatherList : ProductResponse){
        this.productsList = weatherList
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return ProductListViewType.VERTICAL.value

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {

            ProductListViewType.VERTICAL.value -> {
                val binding = ItemVerticalProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ProductVerticalItemViewHolder(binding.root, parent.context)
            }

            else -> {
                val binding = HorizontalProductContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ProductHorizontalViewHolder(binding.root, parent.context)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductVerticalItemViewHolder)
            holder.bind(productsList.products.get(position))
        else
            return
    }

    override fun getItemCount(): Int {
        return productsList.products.size
    }


}