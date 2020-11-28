package com.fernanda.abreu.mobilechallenge.network

import com.fernanda.abreu.mobilechallenge.feature_home.repository.model.ResponseModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface HomeService {
    @GET("products")
    fun getProducts(): Deferred<Response<ResponseModel>>
}