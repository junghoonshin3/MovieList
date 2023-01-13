package com.sjh.data.remote

import android.util.Log
import com.sjh.data.remote.api.MovieService
import com.sjh.data.remote.source.MovieDatabase
import com.sjh.domain.model.MovieEntity
import com.sjh.domain.model.SearchResultEntity
import com.sjh.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MovieRepositoryImpl @Inject constructor(
    private val service: MovieService
//    ,
//    private val database: MovieDatabase
) : MovieRepository {

    override suspend fun getNaverMovieList(title: String?): Flow<SearchResultEntity> {
        return flow {
            val temp = service.getNaverMovieList(title)
            val data = SearchResultEntity(
                temp.lastBuildDate,
                temp.total,
                temp.start,
                temp.display,
                temp.items.map {
                    MovieEntity(
                        it.title,
                        it.link,
                        it.image,
                        it.subtitle,
                        it.pubDate,
                        it.director,
                        it.actor,
                        it.userRating
                    )
                }
            )
            emit(data)
        }.flowOn(Dispatchers.IO)
    }


}