package com.android.learndagger.networking

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import javax.inject.Inject
import javax.inject.Named

class ImageLoader @Inject constructor(@Named("activity_context") private val context: Context) {

    fun loadImage(target:ImageView,imageUrl:String){
        Glide.with(context)
                .load(imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(target)
    }

}