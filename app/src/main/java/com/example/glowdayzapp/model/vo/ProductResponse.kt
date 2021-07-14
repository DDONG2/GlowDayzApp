package com.example.glowdayzapp.model.vo

import com.google.gson.annotations.SerializedName

data class ProductResponse(

    @SerializedName("products")
    var products: List<ProductVO>

)