package com.fernanda.abreu.mobilechallenge.feature_home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fernanda.abreu.mobilechallenge.feature_home.repository.HomeRepository

class HomeViewModelFactory(private val homeRepository: HomeRepository) : ViewModelProvider.NewInstanceFactory() {
    override  fun <T: ViewModel?> create(modelClass: Class<T>):T{
        return HomeViewModel(homeRepository) as T
    }
}