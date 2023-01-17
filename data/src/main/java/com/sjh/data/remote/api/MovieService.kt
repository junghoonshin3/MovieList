package com.sjh.data.remote.api

import android.annotation.SuppressLint
import com.sjh.data.remote.model.BoxOfficeResult
import com.sjh.data.remote.model.NaverMovieList
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import java.text.SimpleDateFormat
import java.util.Date

interface MovieService {

    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    suspend fun getBoxOfficeList(
        @Query("key") key:String? = "f5eef3421c602c6cb7ea224104795888",
        @SuppressLint("SimpleDateFormat") @Query("targetDt") targetDt:String? = "20230115"

    ): BoxOfficeResult

    @GET("https://openapi.naver.com/v1/search/movie.json")
    suspend fun getNaverMovie(
        @Query("query") title: String
    ): NaverMovieList
}