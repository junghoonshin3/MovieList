package com.sjh.domain.repository

import com.sjh.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getNaverMovieList() : Flow<List<Movie>>
}