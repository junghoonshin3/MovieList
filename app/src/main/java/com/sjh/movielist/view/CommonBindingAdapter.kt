package com.sjh.movielist.view

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object CommonBindingAdapter {

    @BindingAdapter("imgResId")
    @JvmStatic
    fun setImageResourceFromNetwork(view: AppCompatImageView, url: String?) {
        Glide.with(view.context)
            .load(url)
            .override(1000)
            .into(view)
    }

}