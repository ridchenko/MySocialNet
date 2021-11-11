package com.example.mysocialnet.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun ImageView.loadCircular(path: String?, @DrawableRes placeHolder: Int) {
    Glide.with(this)
        .load(path)
        .placeholder(placeHolder)
        .circleCrop()
        .into(this)
}
fun ImageView.load(path: String?, @DrawableRes placeHolder: Int) {
    Glide.with(this)
        .load(path)
        .placeholder(placeHolder)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}