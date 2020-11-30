package com.fernanda.abreu.mobilechallenge.util

import android.widget.ImageView
import com.fernanda.abreu.mobilechallenge.R
import com.squareup.picasso.Picasso

object ImageUtil {
    fun setImage(url: String,imgv: ImageView) {
        Picasso
            .get()
            .load(url)
            .error(R.drawable.ic_cloud_off_black_24dp)
            .into(imgv)
    }
}