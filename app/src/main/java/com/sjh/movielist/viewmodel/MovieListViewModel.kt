package com.sjh.movielist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sjh.domain.usecase.GetNaverMovieUseCase
import com.sjh.movielist.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getNaverMovieUseCase: GetNaverMovieUseCase
) : BaseViewModel() {

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _test: MutableStateFlow<String> = MutableStateFlow("테스트용")
    val test: StateFlow<String> = _test


    init {
        getNaverMovieList("슬램덩크")
    }

    fun getNaverMovieList(title: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            getNaverMovieUseCase.invoke(title).onStart {
                _isLoading.value = true
            }.catch {

            }.collect {
                _isLoading.value = false

            }
        }
    }

}