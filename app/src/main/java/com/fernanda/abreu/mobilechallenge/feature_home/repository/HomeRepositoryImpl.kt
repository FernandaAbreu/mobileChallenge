package com.fernanda.abreu.mobilechallenge.feature_home.repository

import androidx.annotation.WorkerThread
import com.fernanda.abreu.mobilechallenge.feature_home.repository.model.ResponseModel
import com.fernanda.abreu.mobilechallenge.network.HomeService

class HomeRepositoryImpl(private val service: HomeService) : HomeRepository {
    @WorkerThread
    override suspend fun getProducts(): ResponseModel? {
       val result= service.getProducts().await()
        return result.body()
    }
}