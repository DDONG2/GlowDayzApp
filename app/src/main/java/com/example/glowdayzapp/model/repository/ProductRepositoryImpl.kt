package com.example.glowdayzapp.model.repository

import com.example.glowdayzapp.model.network.RetrofitClient


class ProductRepositoryImpl :ProductRepository {

    override suspend fun requestProductApi(page: Int)  = RetrofitClient.get().searchProduct(page)
}