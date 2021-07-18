package com.example.glowdayzapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.glowdayzapp.BaseViewModel
import com.example.glowdayzapp.model.repository.ProductRepository
import com.example.glowdayzapp.model.repository.ProductRepositoryImpl
import com.example.glowdayzapp.model.vo.ProductAllList
import com.example.glowdayzapp.model.vo.ProductRecommResponse
import com.example.glowdayzapp.model.vo.ProductResponse
import com.example.glowdayzapp.model.vo.ProductVO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainViewModel : BaseViewModel() {

    private val productRepository: ProductRepository

    init {
        productRepository = ProductRepositoryImpl()
    }

    private val _ProductLiveData = MutableLiveData<List<ProductAllList>>()
    val ProductLiveData: LiveData<List<ProductAllList>>
        get() = _ProductLiveData

    private val _MoreProductLiveData = MutableLiveData<List<ProductAllList>>()
    val MoreProductLiveData: LiveData<List<ProductAllList>>
        get() = _MoreProductLiveData


    private val _ErrorMessage = MutableLiveData<String>()
    val ErrorMessage: LiveData<String>
        get() = _ErrorMessage

    private var pageNumber: Int = 1

    private var TempProduct = mutableListOf<ProductVO>()

    private val productAllList = mutableListOf<ProductAllList>()


    private lateinit var recommendproductsList : ProductRecommResponse


    fun getProductFirstInfo() {

        viewModelScope.launch {
                val productResponse = async { productRepository.requestProductApi(pageNumber) }
                val recommendResponse = async { productRepository.requestRecommendProductApi() }
                computeResult(productResponse.await(), recommendResponse.await())
        }

    }

    private fun computeResult(productResponse: Response<ProductResponse>, recommendResponse: Response<ProductRecommResponse>) {

         recommendResponse.body()?.let {
             recommendproductsList = it
         }

        productResponse.body()?.products?.forEach {
            productAllList.add(ProductAllList(it,null))
        }
        productAllList.add(10, ProductAllList(null, recommendproductsList.recommend1))
        productAllList.add(21, ProductAllList(null, recommendproductsList.recommend2))

        _ProductLiveData.value = productAllList


    }


    fun getMoreProductInfo() {

        pageNumber++

        viewModelScope.launch {
            val response = productRepository.requestProductApi(pageNumber)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    response.body()?.products?.forEach {
                        productAllList.add(ProductAllList(it,null))
                    }

                    if(pageNumber == 2) {
                        productAllList.add(32, ProductAllList(null, recommendproductsList.recommend3)
                        )
                    }

                    _MoreProductLiveData.value = productAllList

                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {
        _ErrorMessage.value = message
    }
}


