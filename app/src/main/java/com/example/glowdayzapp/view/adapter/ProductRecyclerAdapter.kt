package com.example.glowdayzapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.glowdayzapp.databinding.HorizontalProductContainerBinding
import com.example.glowdayzapp.databinding.ItemVerticalProductBinding
import com.example.glowdayzapp.model.vo.*
import com.example.glowdayzapp.view.viewholder.ProductHorizontalViewHolder
import com.example.glowdayzapp.view.viewholder.ProductVerticalItemViewHolder

class ProductRecyclerAdapter(private val VerticalItemClickListener: (product: ProductVO) -> Unit, private val HorizontalItemClickListener: (product: RecommendProductVO) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private  var productsList :List<ProductAllList> = listOf<ProductAllList>()


    fun setProductList(productList : List<ProductAllList>){
        this.productsList = productList
        notifyDataSetChanged()
    }


    override fun getItemViewType(position: Int): Int {


        if (position == 10 || position == 21 || position == 32)
            return ProductListViewType.HORIZONTAL.value

        return ProductListViewType.VERTICAL.value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when(viewType) {

            ProductListViewType.VERTICAL.value -> {
                val binding = ItemVerticalProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ProductVerticalItemViewHolder(binding.root, parent.context, VerticalItemClickListener)
            }

            else -> {
                val binding = HorizontalProductContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ProductHorizontalViewHolder(binding.root, parent.context, HorizontalItemClickListener)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is ProductVerticalItemViewHolder)
            holder.bind(productsList.get(position))
        else if(holder is ProductHorizontalViewHolder)
            holder.bind(productsList.get(position))
    }

    override fun getItemCount(): Int {
        return productsList.size
    }


}