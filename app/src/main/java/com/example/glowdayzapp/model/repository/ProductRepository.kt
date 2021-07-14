package com.example.glowdayzapp.model.repository

import com.example.glowdayzapp.model.vo.ProductResponse
import retrofit2.Response

interface ProductRepository {

    suspend fun requestProductApi(page: Int) : Response<ProductResponse>


}