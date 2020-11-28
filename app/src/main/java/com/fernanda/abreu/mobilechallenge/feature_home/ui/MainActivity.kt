package com.fernanda.abreu.mobilechallenge.feature_home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fernanda.abreu.mobilechallenge.R
import com.fernanda.abreu.mobilechallenge.feature_home.viewmodel.HomeViewModel
import com.fernanda.abreu.mobilechallenge.feature_home.viewmodel.HomeViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity() , KodeinAware {

    override val kodein: Kodein by kodein()
    private val viewModelFactory : HomeViewModelFactory by instance()
    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        viewModel.fetchProducts().observe(this, Observer {

        })
    }




}
