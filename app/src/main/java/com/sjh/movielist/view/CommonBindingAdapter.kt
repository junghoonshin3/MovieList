package com.sjh.movielist.view

import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sjh.domain.model.TMDBMovieEntity
import com.sjh.movielist.core.base.BaseRecyclerViewAdapter
import com.sjh.movielist.core.base.BaseViewModel
import com.sjh.movielist.core.utils.Common

object CommonBindingAdapter {

    @BindingAdapter("imgResId")
    @JvmStatic
    fun setImageResourceFromNetwork(view: AppCompatImageView, url: String?) {
        Glide.with(view.context)
            .load(url)
            .override(1000)
            .into(view)
    }

    @BindingAdapter(value = ["items", "itemClickListener"])
    @JvmStatic
    fun setRecyclerAdapter(
        vp: ViewPager2,
        items: List<TMDBMovieEntity>?,
        itemClickListener: BaseRecyclerViewAdapter.OnItemClickListener<TMDBMovieEntity>
    ) {
        items?.let {
            vp.apply {
                adapter = MovieListAdapter(it).apply {
                    setOnItemClickListener(itemClickListener)
                }
                offscreenPageLimit = 3
                currentItem = if (Common.MAX_COUNT % 2 == 0) {
                    Common.MAX_COUNT / 2
                } else {
                    Common.MAX_COUNT / 2 + 1
                }
                setPageTransformer(ZoomOutPageTransformer())
            }
        }

    }
}