package com.fernanda.abreu.mobilechallenge.feature_home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fernanda.abreu.mobilechallenge.feature_home.repository.HomeRepository
import com.fernanda.abreu.mobilechallenge.feature_home.repository.model.ResponseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {
    private val homeLiveData = MutableLiveData<ResponseModel>()

    fun fetchProducts():MutableLiveData<ResponseModel>{
        CoroutineScope(Dispatchers.IO).launch{
            val result = homeRepository.getProducts()
            withContext(Dispatchers.Main){
                homeLiveData.postValue(result)
            }

        }
        return homeLiveData
    }
}