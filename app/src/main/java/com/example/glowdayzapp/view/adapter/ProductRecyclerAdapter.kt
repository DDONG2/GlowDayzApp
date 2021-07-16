package com.example.glowdayzapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.glowdayzapp.databinding.HorizontalProductContainerBinding
import com.example.glowdayzapp.databinding.ItemVerticalProductBinding
import com.example.glowdayzapp.model.vo.*
import com.example.glowdayzapp.view.viewholder.ProductHorizontalViewHolder
import com.example.glowdayzapp.view.viewholder.ProductVerticalItemViewHolder

class ProductRecyclerAdapter(private val VerticalItemClickListener: (product: ProductVO) -> Unit, private val HorizontalItemClickListener: (product: ProductVO) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private  var productsList :List<ProductVO> = listOf<ProductVO>()

    private lateinit var recommendproductsList : ProductRecommResponse


    fun setProductList(productList : List<ProductVO>){
        this.productsList = productList
        notifyDataSetChanged()
    }


    fun setRecommendProductList(recommendProductList : ProductRecommResponse){
        this.recommendproductsList = recommendProductList
    }

    override fun getItemViewType(position: Int): Int {


        if (position == 11 || position == 21 || position == 31)
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
            holder.bind(recommendproductsList)
    }

    override fun getItemCount(): Int {
        return productsList.size
    }


}