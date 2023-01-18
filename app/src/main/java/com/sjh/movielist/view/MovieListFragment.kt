package com.sjh.movielist.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.sjh.domain.model.TMDBMovieEntity
import com.sjh.movielist.BR
import com.sjh.movielist.R
import com.sjh.movielist.core.base.BaseFragment
import com.sjh.movielist.core.extension.repeatOnStarted
import com.sjh.movielist.databinding.FragmentMovieListBinding
import com.sjh.movielist.viewmodel.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment :
    BaseFragment<FragmentMovieListBinding, MovieListViewModel>(R.layout.fragment_movie_list) {
    override val viewModel: MovieListViewModel by viewModels()
    override val bindingId: Int = BR.list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //생명주기에 따라 onStart일때 collect , onStop일때 cancel
        repeatOnStarted {
            binding.vp2MovieList.apply {
                viewModel.searchResult.collect {
                    it?.let {
                        viewPagerInit(this, it)
                    }

                }

            }

        }
    }

    private fun viewPagerInit(vp: ViewPager2, items: List<TMDBMovieEntity>) {
        items.let { it ->
            vp.apply {
                adapter = MovieListAdapter(it)
                currentItem = 1
                offscreenPageLimit = 2
                setPageTransformer(ZoomOutPageTransformer())
                onInfinitePageChangeCallback(this, it.size + 2)
            }

        }
    }

    private fun onInfinitePageChangeCallback(vp: ViewPager2, listSize: Int) {
        vp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    when (vp.currentItem) {
                        listSize - 1 -> {
                            vp.setCurrentItem(1, false)
                        }
                        0 -> {
                            vp.setCurrentItem(listSize - 2, false)
                        }
                    }
                }
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position != 0 && position != listSize - 1) {
                    // pageIndicatorView.setSelected(position-1)
                    Log.i("sjh","${position}")
                }
            }
        })
    }
}