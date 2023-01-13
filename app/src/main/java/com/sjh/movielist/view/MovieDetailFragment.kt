package com.sjh.movielist.view

import androidx.fragment.app.viewModels
import com.sjh.movielist.BR
import com.sjh.movielist.R
import com.sjh.movielist.core.base.BaseFragment
import com.sjh.movielist.databinding.FragmentMovieDetailBinding
import com.sjh.movielist.viewmodel.MovieDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment :
    BaseFragment<FragmentMovieDetailBinding, MovieDetailViewModel>(R.layout.fragment_movie_detail) {
    override val viewModel: MovieDetailViewModel by viewModels()
    override val bindingId: Int = BR.detail
}