package com.sjh.domain.repository

import com.sjh.domain.model.SearchResultEntity
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getNaverMovieList(title: String?): Flow<SearchResultEntity>
}