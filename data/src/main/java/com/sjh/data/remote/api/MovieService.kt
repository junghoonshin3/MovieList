package com.sjh.data.remote.api

import android.annotation.SuppressLint
import com.sjh.data.remote.model.BoxOfficeResult
import com.sjh.data.remote.model.NaverMovieList
import com.sjh.data.remote.model.TMDBMovieResult
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import java.text.SimpleDateFormat
import java.util.Date

interface MovieService {

    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    suspend fun getBoxOfficeList(
        @Query("key") key: String? = "f5eef3421c602c6cb7ea224104795888",
        @SuppressLint("SimpleDateFormat") @Query("targetDt") targetDt: String? = "20230115"

    ): BoxOfficeResult

    @GET("https://openapi.naver.com/v1/search/movie.json")
    suspend fun getNaverMovie(
        @Query("query") title: String
    ): NaverMovieList

    @GET("/3/discover/movie?")
    suspend fun getTMDBMovie(
        @Query("api_key") api_key: String? = "7d861d74f229cf2c943fc79e8bf18966",
        @Query("language") language: String? = "ko",
        @Query("region") region: String? = "KR",
        @Query("sort_by") sort_by: String? = "popularity.desc",
        @Query("include_adult") include_adult: String? = "false",
        @Query("include_video") include_video: String? = "false",
        @Query("page") page: String? = "1",
        @Query("with_watch_monetization_types") with_watch_monetization_types: String? = "flatrate",
    ): TMDBMovieResult
}