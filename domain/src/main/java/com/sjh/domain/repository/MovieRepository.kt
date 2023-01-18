package com.sjh.domain.repository

import com.sjh.domain.model.BoxOfficeResultEntity
import com.sjh.domain.model.NaverMovieListEntity
import com.sjh.domain.model.TMDBMovieResultEntity
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getBoxOfficeList(): Flow<BoxOfficeResultEntity>
    suspend fun getNaverMovieList(title: String): Flow<NaverMovieListEntity>
    suspend fun getTMDBMovieList(): Flow<TMDBMovieResultEntity>
}