package com.sjh.movielist.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.sjh.movielist.BR
import com.sjh.movielist.R
import com.sjh.movielist.core.base.BaseActivity
import com.sjh.movielist.databinding.ActivityMainBinding
import com.sjh.movielist.viewmodel.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MovieListViewModel>(R.layout.activity_main) {
    override val viewModel: MovieListViewModel by viewModels()

    override val bindingId: Int = BR.main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }

}