package com.example.glowdayzapp.model.vo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecommendProductVO(
    @SerializedName("idProduct")
    var idProduct: Int = 0,

    @SerializedName("productTitle")
    var productTitle: String = "",

    @SerializedName("ratingAvg")
    var ratingAvg: Double = 0.0,

    @SerializedName("reviewCount")
    var reviewCount: String = "",

    @SerializedName("imageUrl")
    var imageUrl: String = "",
) : Parcelable
