package com.example.glowdayzapp.model.vo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class brandVO(
    @SerializedName("idBrand")
    val idBrand: Int,

    @SerializedName("brandTitle")
    val brandTitle: String,

    @SerializedName("imageUrl")
    val imageUrl: String

) : Parcelable