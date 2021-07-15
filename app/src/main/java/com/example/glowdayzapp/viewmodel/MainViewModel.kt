package com.example.glowdayzapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.glowdayzapp.BaseViewModel
import com.example.glowdayzapp.model.repository.ProductRepository
import com.example.glowdayzapp.model.repository.ProductRepositoryImpl
import com.example.glowdayzapp.model.vo.ProductResponse
import com.example.glowdayzapp.model.vo.ProductVO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : BaseViewModel() {

    private val productRepository: ProductRepository

    init {
        productRepository = ProductRepositoryImpl()
    }

    private val _ProductLiveData = MutableLiveData<ProductResponse>()
    val ProductLiveData: LiveData<ProductResponse>
        get() = _ProductLiveData

    private val _MoreProductLiveData = MutableLiveData<ProductResponse>()
    val MoreProductLiveData: LiveData<ProductResponse>
        get() = _MoreProductLiveData

    private val _ErrorMessage = MutableLiveData<String>()
    val ErrorMessage: LiveData<String>
        get() = _ErrorMessage


    private  var TempProduct = mutableListOf<ProductVO>()

    private lateinit var MoreProductResponse: ProductResponse


    fun getProductInfo(page :Int) {
        viewModelScope.launch {
            val response = productRepository.requestProductApi(page)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    response.body()?.let { TempProduct.addAll(it.products) }

                    _ProductLiveData.value = response.body()

                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    fun getMoreProductInfo(page :Int) {
        viewModelScope.launch {
            val response = productRepository.requestProductApi(page)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    response.body()?.let { TempProduct.addAll(it.products) }

                    MoreProductResponse = ProductResponse(TempProduct)

                    _MoreProductLiveData.value = MoreProductResponse

                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {
        _ErrorMessage.postValue(message)
    }
}


