package com.fernanda.abreu.mobilechallenge.feature_home.repository.model

import com.google.gson.annotations.SerializedName

data class Products (
    @SerializedName("name") val name : String,
    @SerializedName("imageURL") val imageURL : String,
    @SerializedName("description") val description : String
)