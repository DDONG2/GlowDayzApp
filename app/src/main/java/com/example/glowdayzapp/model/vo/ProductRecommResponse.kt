package com.example.glowdayzapp.model.vo

import com.google.gson.annotations.SerializedName

data class ProductRecommResponse(

    @SerializedName("recommend1")
    var recommend1: List<RecommendProductVO>,

    @SerializedName("recommend2")
    var recommend2: List<RecommendProductVO>,

    @SerializedName("recommend3")
    var recommend3: List<RecommendProductVO>
)
