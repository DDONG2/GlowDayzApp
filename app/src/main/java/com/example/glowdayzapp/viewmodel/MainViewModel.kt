package com.example.glowdayzapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.glowdayzapp.BaseViewModel
import com.example.glowdayzapp.model.repository.ProductRepository
import com.example.glowdayzapp.model.repository.ProductRepositoryImpl
import com.example.glowdayzapp.model.vo.ProductResponse
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

    private val _ErrorMessage = MutableLiveData<String>()
    val ErrorMessage: LiveData<String>
        get() = _ErrorMessage


    fun getProductInfo() {
        viewModelScope.launch {
            val response = productRepository.requestProductApi(1)
            withContext(Dispatchers.Main) { //withContext() 의 다음 코드를 수행하지 않습니다. withContext()가 수행되고 난후 다음 코드가 실행됩니다.  또한 UI 변경등은 Main쓰레드 에서 실행해야합니다.
                if (response.isSuccessful) {

                    _ProductLiveData.value = response.body()

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


