package com.example.glowdayzapp.model.vo

import com.google.gson.annotations.SerializedName

data class ProductVO(
    @SerializedName("idProduct")
    var idProduct: Int = 0,

    @SerializedName("idBrand")
    var idBrand: Int = 0,

    @SerializedName("productTitle")
    var productTitle: String = "",

    @SerializedName("volume")
    var volume: String = "",

    @SerializedName("price")
    var price: Int = 0,

    @SerializedName("productScore")
    var productScore: Double = 0.0,

    @SerializedName("ratingAvg")
    var ratingAvg: Double = 0.0,

    @SerializedName("productRank")
    var productRank: String = "",

    @SerializedName("rankChange")
    var rankChange: String = "",

    @SerializedName("rankChangeType")
    var rankChangeType: String = "",

    @SerializedName("reviewCount")
    var reviewCount: String = "",

    @SerializedName("imageUrl")
    var imageUrl: String = "",

    @SerializedName("brand")
    var brand: brandVO
)
