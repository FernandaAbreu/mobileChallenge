package com.fernanda.abreu.mobilechallenge.feature_home.repository

import com.fernanda.abreu.mobilechallenge.network.AppRetrofit
import com.fernanda.abreu.mobilechallenge.network.HomeService
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class HomeRepositoryTest {

    @Test
    fun getProducts() {

        runBlocking {
            val service = AppRetrofit.getInstance().create(HomeService::class.java)
            val result= HomeRepositoryImpl(service).getProducts()
            assertNotNull(result)
            assertNotNull(result?.products)
            assertNotNull(result?.spotlight)
            assertNotNull(result?.cash)
            assertFalse(result?.products!!.isEmpty())
            assertFalse(result?.spotlight!!.isEmpty())

        }
    }
}
