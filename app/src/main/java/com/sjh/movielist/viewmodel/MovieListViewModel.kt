package com.sjh.movielist.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.sjh.domain.model.BoxOfficeResultEntity
import com.sjh.domain.model.MovieEntity
import com.sjh.domain.usecase.GetBoxOfficeMovieUseCase
import com.sjh.domain.usecase.GetNaverMovieListUseCase
import com.sjh.movielist.core.base.BaseViewModel
import com.sjh.movielist.core.extension.MutableEventFlow
import com.sjh.movielist.core.extension.asEventFlow
import com.sjh.movielist.view.MovieListAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getBoxOfficeUseCase: GetBoxOfficeMovieUseCase,
    private val getNaverMovieUseCase: GetNaverMovieListUseCase
) : BaseViewModel() {

    init {
        viewModelScope.launch {
            getBoxOfficeList()
        }
    }

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _searchResult: MutableStateFlow<List<MovieEntity>?> = MutableStateFlow(null)
    val searchResult: StateFlow<List<MovieEntity>?> = _searchResult


    suspend fun getBoxOfficeList() {
        viewModelScope.launch(Dispatchers.IO) {
            getBoxOfficeUseCase().onStart { _isLoading.value = true }.catch {

            }.collect {
                _isLoading.value = false
                var list = it.boxOfficeResult.dailyBoxOfficeList.map { movie ->
                    delay(500)
                    async(Dispatchers.IO) {

                        getNaverMovie(movie.movieNm)
                            .filter {
                                it.items.isNotEmpty()
                            }
                            .collect { naverMovie ->
                                var imageUrl = naverMovie.items[0].image
                                movie.movieUrl = imageUrl
                            }
                    }
                    movie
                }
                _searchResult.value = list
            }
        }
    }


    suspend fun getNaverMovie(title: String) = getNaverMovieUseCase.invoke(title)


}