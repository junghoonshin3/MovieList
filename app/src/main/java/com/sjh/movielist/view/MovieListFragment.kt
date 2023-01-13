package com.sjh.movielist.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sjh.movielist.BR
import com.sjh.movielist.R
import com.sjh.movielist.core.base.BaseFragment
import com.sjh.movielist.databinding.FragmentMovieListBinding
import com.sjh.movielist.viewmodel.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieListFragment :
    BaseFragment<FragmentMovieListBinding, MovieListViewModel>(R.layout.fragment_movie_list) {
    override val viewModel: MovieListViewModel by viewModels()
    override val bindingId: Int = BR.list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        lifecycleScope.launch {
            viewModel.test.collect({

            })
        }

        binding.btnDetail.setOnClickListener {
            findNavController().navigate(MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment())
        }

    }


}