package com.fernanda.abreu.mobilechallenge.feature_home.repository

import androidx.annotation.WorkerThread
import com.fernanda.abreu.mobilechallenge.feature_home.repository.model.ResponseModel

interface HomeRepository {
    @WorkerThread
    suspend fun  getProducts(): ResponseModel?
}