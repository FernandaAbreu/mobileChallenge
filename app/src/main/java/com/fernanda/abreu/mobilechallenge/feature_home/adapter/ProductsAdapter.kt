package com.fernanda.abreu.mobilechallenge.feature_home.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fernanda.abreu.mobilechallenge.R
import com.fernanda.abreu.mobilechallenge.feature_home.repository.model.Products
import com.fernanda.abreu.mobilechallenge.util.ImageUtil
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cash_cardview.*
import kotlinx.android.synthetic.main.item_products.view.*

class ProductsAdapter(private val products: List<Products>,
                      private val context: Context): RecyclerView.Adapter<ProductsAdapter.ViewHolder>()
 {
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsAdapter.ViewHolder {
         val view = LayoutInflater.from(context).inflate(R.layout.item_products, parent, false)
         return ViewHolder(view)
     }

     override fun getItemCount(): Int {
         return products.size
     }

     override fun onBindViewHolder(holder: ProductsAdapter.ViewHolder, position: Int) {
         val product = products[position]
         holder?.let {
             it.bindView(product)
         }
     }
     inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         fun bindView(product: Products) {
             val img = itemView.imgv_product
             img.contentDescription=product.description
             if (!product.imageURL.isNullOrBlank()) {
                 ImageUtil.setImage(product.imageURL,img)
             }
         }
     }

 }