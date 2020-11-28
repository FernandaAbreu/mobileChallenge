package com.fernanda.abreu.mobilechallenge.feature_home.repository.model

import com.google.gson.annotations.SerializedName

class ResponseModel(
    @SerializedName("spotlight") val spotlight: List<Spotlight> = mutableListOf(),
    @SerializedName("products") val products: List<Products> = mutableListOf(),
    @SerializedName("cash") val cash: Cash? = null
)