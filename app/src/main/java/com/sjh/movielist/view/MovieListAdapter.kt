package com.sjh.movielist.view

import android.util.Log
import com.sjh.domain.model.MovieEntity
import com.sjh.domain.model.TMDBMovieEntity
import com.sjh.movielist.R
import com.sjh.movielist.core.base.BaseRecyclerViewAdapter
import com.sjh.movielist.databinding.RvMovieItemBinding

class MovieListAdapter(items: List<TMDBMovieEntity>) :
    BaseRecyclerViewAdapter<TMDBMovieEntity, RvMovieItemBinding>(items) {

//    private val newList = listOf(items.last()) + items + listOf(items.first())

    override fun getLayoutResId(): Int = R.layout.rv_movie_item

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.binding?.movieItem = items[position % items.size]

    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }


}