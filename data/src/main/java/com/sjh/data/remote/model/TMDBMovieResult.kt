package com.sjh.data.remote.model

data class TMDBMovieResult(
    val page: String,
    val results: List<TMDBMovie>,
    val total_pages: String,
    val total_results: String
)