package com.example.glowdayzapp.model.vo

import com.google.gson.annotations.SerializedName

data class brandVO(
    @SerializedName("idBrand")
    val idBrand: Int,

    @SerializedName("brandTitle")
    val brandTitle: String,

    @SerializedName("imageUrl")
    val imageUrl: String

)