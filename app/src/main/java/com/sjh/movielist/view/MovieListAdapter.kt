package com.sjh.movielist.view

import com.sjh.domain.model.TMDBMovieEntity
import com.sjh.movielist.R
import com.sjh.movielist.core.base.BaseRecyclerViewAdapter
import com.sjh.movielist.core.utils.Common.MAX_COUNT
import com.sjh.movielist.databinding.RvMovieItemBinding

class MovieListAdapter(items: List<TMDBMovieEntity>) :
    BaseRecyclerViewAdapter<TMDBMovieEntity, RvMovieItemBinding>(items) {

    override fun getLayoutResId(): Int = R.layout.rv_movie_item

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.binding?.movieItem = items[position % items.size]
        holder.binding?.root?.setOnClickListener {
            listener?.onClick(items[position % items.size], position % items.size)
        }
    }

    override fun getItemCount(): Int {
        return MAX_COUNT
    }


}