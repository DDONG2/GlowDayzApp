package com.example.glowdayzapp.model.repository

import com.example.glowdayzapp.model.network.RetrofitClient
import com.example.glowdayzapp.model.vo.ProductResponse
import retrofit2.Response


class ProductRepositoryImpl :ProductRepository {

    override suspend fun requestProductApi(page: Int)  = RetrofitClient.get().searchProduct(page)

    override suspend fun requestRecommendProductApi() = RetrofitClient.get().searchRecommendProduct()
}