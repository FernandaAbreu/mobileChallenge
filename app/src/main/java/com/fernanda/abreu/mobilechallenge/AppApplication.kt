package com.fernanda.abreu.mobilechallenge

import android.app.Application
import com.fernanda.abreu.mobilechallenge.feature_home.repository.HomeRepository
import com.fernanda.abreu.mobilechallenge.feature_home.repository.HomeRepositoryImpl
import com.fernanda.abreu.mobilechallenge.feature_home.viewmodel.HomeViewModelFactory
import com.fernanda.abreu.mobilechallenge.network.AppRetrofit
import com.fernanda.abreu.mobilechallenge.network.HomeService
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class AppApplication: Application() , KodeinAware {
    override val kodein by Kodein.lazy {
        bind<HomeService>() with singleton { AppRetrofit.getInstance().create(HomeService::class.java) }
        bind<HomeRepository>() with provider { HomeRepositoryImpl(instance()) }
        bind() from provider { HomeViewModelFactory(instance()) }
    }
}