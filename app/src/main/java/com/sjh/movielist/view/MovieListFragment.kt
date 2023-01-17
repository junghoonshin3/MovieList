package com.sjh.movielist.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sjh.movielist.BR
import com.sjh.movielist.R
import com.sjh.movielist.core.base.BaseFragment
import com.sjh.movielist.core.extension.repeatOnStarted
import com.sjh.movielist.databinding.FragmentMovieListBinding
import com.sjh.movielist.viewmodel.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieListFragment :
    BaseFragment<FragmentMovieListBinding, MovieListViewModel>(R.layout.fragment_movie_list) {
    override val viewModel: MovieListViewModel by viewModels()
    override val bindingId: Int = BR.list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //생명주기에 따라 onStart일때 collect , onStop일때 cancel
        repeatOnStarted {
            viewModel.searchResult.collect {
                binding.rvMovieList.adapter = it?.let { it -> MovieListAdapter(it) }
            }
        }
    }


}