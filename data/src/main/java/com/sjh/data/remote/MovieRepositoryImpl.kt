package com.sjh.data.remote

import com.sjh.data.remote.api.MovieService
import com.sjh.domain.model.*
import com.sjh.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MovieRepositoryImpl @Inject constructor(
    private val service: MovieService
//    ,
//    private val database: MovieDatabase
) : MovieRepository {

    override suspend fun getBoxOfficeList(): Flow<BoxOfficeResultEntity> {
        return flow {
            val temp = service.getBoxOfficeList().boxOfficeResult
            val data = BoxOfficeResultEntity(
                BoxOfficeEntity(
                    temp.boxofficeType,
                    temp.showRange,
                    temp.dailyBoxOfficeList.map {
                        MovieEntity(
                            it.rnum,
                            it.rank,
                            it.rankInten,
                            it.rankOldAndNew,
                            it.movieCd,
                            it.movieNm,
                            it.openDt,
                            it.salesAmt,
                            it.salesShare,
                            it.salesInten,
                            it.salesChange,
                            it.salesAcc,
                            it.audiCnt,
                            it.audiInten,
                            it.audiChange,
                            it.audiAcc,
                            it.scrnCnt,
                            it.showCnt,
                            it.movieUrl
                        )
                    }
                )

            )
            emit(data)
        }.flowOn(Dispatchers.IO)

    }

    override suspend fun getNaverMovieList(title: String): Flow<NaverMovieListEntity> {
        return flow {
            val temp = service.getNaverMovie(title)
            val data = NaverMovieListEntity(
                temp.lastBuildDate,
                temp.total,
                temp.start,
                temp.display,
                temp.items.map {
                    NaverMovieEntity(
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

    override suspend fun getTMDBMovieList(): Flow<TMDBMovieResultEntity> {
        return flow {
            val temp = service.getTMDBMovie()
            val data = TMDBMovieResultEntity(
                temp.page,
                temp.results.map {
                    TMDBMovieEntity(
                        it.adult,
                        it.backdrop_path,
                        it.genre_ids,
                        it.id,
                        it.original_language,
                        it.original_title,
                        it.overview,
                        it.popularity,
                        "https://image.tmdb.org/t/p/original"+it.poster_path,
                        it.release_date,
                        it.title,
                        it.video,
                        it.vote_average,
                        it.vote_count
                    )
                },
                temp.total_pages,
                temp.total_results,
            )
            emit(data)
        }.flowOn(Dispatchers.IO)
    }


}