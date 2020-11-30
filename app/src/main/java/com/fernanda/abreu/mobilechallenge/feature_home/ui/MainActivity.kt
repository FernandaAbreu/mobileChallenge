package com.fernanda.abreu.mobilechallenge.feature_home.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.test.espresso.idling.CountingIdlingResource
import com.fernanda.abreu.mobilechallenge.R
import com.fernanda.abreu.mobilechallenge.feature_home.adapter.ProductsAdapter
import com.fernanda.abreu.mobilechallenge.feature_home.adapter.SpotlightsAdapter
import com.fernanda.abreu.mobilechallenge.feature_home.repository.model.Cash
import com.fernanda.abreu.mobilechallenge.feature_home.repository.model.Products
import com.fernanda.abreu.mobilechallenge.feature_home.repository.model.Spotlight
import com.fernanda.abreu.mobilechallenge.feature_home.viewmodel.HomeViewModel
import com.fernanda.abreu.mobilechallenge.feature_home.viewmodel.HomeViewModelFactory
import com.fernanda.abreu.mobilechallenge.util.ImageUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cash_cardview.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class MainActivity : AppCompatActivity() , KodeinAware {
    lateinit var countingIdlingResource: CountingIdlingResource
    override val kodein: Kodein by kodein()
    private val viewModelFactory : HomeViewModelFactory by instance()
    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        countingIdlingResource = CountingIdlingResource("MainActivity")
        setContentView(R.layout.activity_main)
        countingIdlingResource.increment()
       setLoadingMode()
         viewModel.fetchProducts().observe(this, Observer {
            setSpotlights(it.spotlight)
            setCash(it.cash)
            setProducts(it.products)
            progress_main.visibility= View.GONE
            if(it.products.isEmpty() && it.spotlight.isEmpty() && it.cash==null){
                showNoDataAlert()
            }else{
                setContentMode()
            }
            countingIdlingResource.decrement()
        })
    }

    private fun setContentMode() {
        progress_main.visibility= View.GONE
        llcontainer_main.visibility=View.VISIBLE
        recycler_view_spotlight.visibility=View.VISIBLE
        recycler_view_products.visibility=View.VISIBLE
        title_products.visibility=View.VISIBLE
        cl_cash.visibility=View.VISIBLE
    }

    private fun showNoDataAlert() {
        progress_main.visibility= View.GONE
        Toast.makeText(this,getString(R.string.generic_error),Toast.LENGTH_LONG).show()

    }

    private fun setLoadingMode() {
        progress_main.visibility= View.VISIBLE
        llcontainer_main.visibility=View.GONE
    }

    private fun setSpotlights(spotlights: List<Spotlight>) {
        if(spotlights.isNullOrEmpty()){
            recycler_view_spotlight.visibility=View.GONE
        }
        val recyclerView = recycler_view_spotlight
        recyclerView.adapter = SpotlightsAdapter(spotlights, this)

    }

    private fun setCash(cash: Cash?) {
        if(cash==null){
            cl_cash.visibility=View.GONE
        }else{
            setCashTitle(cash)
            setCashImage(cash)
        }
    }

    private fun setCashImage(cash: Cash) {
        if (!cash.bannerURL.isNullOrBlank()) {
            ImageUtil.setImage(cash.bannerURL, imgv_cash)
        }
    }

    private fun setCashTitle(cash: Cash) {
        val title = cash.title.split(" ").toTypedArray()
        title_cash.setText(title.first())
        var titlePart2 = ""
        if (title.size >= 2)
            titlePart2 = title.last()
        title_cash_part2.setText(titlePart2)
    }


    private fun setProducts(products: List<Products>) {
        if(products.isNullOrEmpty()){
            recycler_view_products.visibility=View.GONE
            title_products.visibility=View.GONE
        }
        val recyclerView = recycler_view_products
        recyclerView.adapter = ProductsAdapter(products, this)


    }


}
