package com.sjh.movielist.view

import android.util.Log
import com.sjh.domain.model.MovieEntity
import com.sjh.movielist.R
import com.sjh.movielist.core.base.BaseRecyclerViewAdapter
import com.sjh.movielist.databinding.RvMovieItemBinding

class MovieListAdapter(items: List<MovieEntity>) :
    BaseRecyclerViewAdapter<MovieEntity, RvMovieItemBinding>(items) {

    override fun getLayoutResId(): Int = R.layout.rv_movie_item

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
            holder.binding?.movieItem = items[position]


//        if (position <= items.size) {
//            val endPosition = if (position + 6 > items.size) {
//                items.size
//            } else {
//                position + 6
//            }
//            items.subList(position, endPosition).map { it.movieUrl }.forEach {
//                preload(holder.itemView.context, it)
//            }
//        }

    }
//
//    fun preload(context: Context, url: String?) {
//        Glide.with(context).load(url)
//            .preload(150, 150)
//    }
}