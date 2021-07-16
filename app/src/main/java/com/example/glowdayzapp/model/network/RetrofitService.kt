package com.example.glowdayzapp.model.network

import com.example.glowdayzapp.model.vo.ProductRecommResponse
import com.example.glowdayzapp.model.vo.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface RetrofitService {

    @GET("test/app/product.{page}.json")
    suspend fun searchProduct(@Path("page") page: Int): Response<ProductResponse>

    @GET("test/app/recommend_product.json")
    suspend fun searchRecommendProduct(): Response<ProductRecommResponse>

}