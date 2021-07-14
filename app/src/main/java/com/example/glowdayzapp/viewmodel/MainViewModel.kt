package com.example.glowdayzapp.viewmodel

import com.example.glowdayzapp.BaseViewModel
import com.example.glowdayzapp.model.repository.ProductRepository
import com.example.glowdayzapp.model.repository.ProductRepositoryImpl

class MainViewModel : BaseViewModel() {

    private val productRepository: ProductRepository


    init {
        productRepository = ProductRepositoryImpl()
    }


}

