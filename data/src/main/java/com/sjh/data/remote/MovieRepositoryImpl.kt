package com.sjh.data.remote

import com.sjh.data.remote.api.MovieService
import com.sjh.data.remote.source.MovieDatabase
import com.sjh.domain.repository.MovieRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MovieRepositoryImpl @Inject constructor(
    private val service : MovieService,
    private val database : MovieDatabase
) : MovieRepository{
    override suspend fun getNaverMovieList() {
        TODO("Not yet implemented")
    }


}