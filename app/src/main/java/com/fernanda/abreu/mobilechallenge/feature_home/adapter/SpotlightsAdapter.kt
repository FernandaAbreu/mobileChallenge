package com.fernanda.abreu.mobilechallenge.feature_home.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fernanda.abreu.mobilechallenge.R
import com.fernanda.abreu.mobilechallenge.feature_home.repository.model.Spotlight
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_spotlight.view.*


class SpotlightsAdapter(private val spotlights: List<Spotlight>,
                        private val context: Context): RecyclerView.Adapter<SpotlightsAdapter.ViewHolder>()
 {
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotlightsAdapter.ViewHolder {
         val view = LayoutInflater.from(context).inflate(R.layout.item_spotlight, parent, false)
         return ViewHolder(view)
     }

     override fun getItemCount(): Int {
         return spotlights.size
     }

     override fun onBindViewHolder(holder: SpotlightsAdapter.ViewHolder, position: Int) {
         val spotlight = spotlights[position]
         holder?.let {
             it.bindView(spotlight)
         }
     }
     inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         fun bindView(spotlight: Spotlight) {
             val img = itemView.imgv_spotilight
             img.contentDescription=spotlight.name
             if (!spotlight.bannerURL.isNullOrBlank()) {
                 Picasso
                     .get()
                     .load(spotlight.bannerURL)
                     .error(R.drawable.ic_cloud_off_black_24dp)
                     .into(img)
             }
         }
     }

 }