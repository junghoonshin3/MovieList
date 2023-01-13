package com.sjh.data.remote.api

import com.sjh.data.remote.model.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("/v1/search/movie.json")
    suspend fun getNaverMovieList(
        @Query("query") title: String?
    ): SearchResult
}