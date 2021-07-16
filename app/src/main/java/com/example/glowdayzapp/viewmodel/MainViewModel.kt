package com.example.glowdayzapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.glowdayzapp.BaseViewModel
import com.example.glowdayzapp.model.repository.ProductRepository
import com.example.glowdayzapp.model.repository.ProductRepositoryImpl
import com.example.glowdayzapp.model.vo.ProductRecommResponse
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

    private val _RecommendProductLiveData = MutableLiveData<ProductRecommResponse>()
    val RecommendProductLiveData: LiveData<ProductRecommResponse>
        get() = _RecommendProductLiveData


    private val _ErrorMessage = MutableLiveData<String>()
    val ErrorMessage: LiveData<String>
        get() = _ErrorMessage

    private var pageNumber: Int = 1

    private  var TempProduct = mutableListOf<ProductVO>()

    private lateinit var MoreProductResponse: ProductResponse

    //요구사항 왜 이렇게 작성 하였는지등 왜썻는지 장점 단점 ReadME

    fun getProductInfo() {
        viewModelScope.launch {

            val response = productRepository.requestProductApi(pageNumber)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    //flow zip merge 결과값 파라미터 2개가 온다. 스코프를 따로 나눈다. 순서 상관 없이 두개 결과가 모두올때
                    response.body()?.let { TempProduct.addAll(it.products) }

                    _ProductLiveData.value = response.body()
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }

        //Io 2개 레트로핏 결과 MAin -> viewModel PostValue

        viewModelScope.launch {
            val response = productRepository.requestRecommendProductApi()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    _RecommendProductLiveData.value = response.body()

                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }

    }

    fun getMoreProductInfo() {

        pageNumber++

        viewModelScope.launch {
            val response = productRepository.requestProductApi(pageNumber)
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


