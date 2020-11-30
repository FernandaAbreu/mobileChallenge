package com.fernanda.abreu.mobilechallenge.feature_home.repository.model

import com.google.gson.annotations.SerializedName

class Spotlight (
    @SerializedName("name") val name : String,
    @SerializedName("bannerURL") val bannerURL : String,
    @SerializedName("description") val description : String
)
