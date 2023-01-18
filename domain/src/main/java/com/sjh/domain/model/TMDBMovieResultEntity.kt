package com.sjh.domain.model

data class TMDBMovieResultEntity(
    val page: String,
    val results: List<TMDBMovieEntity>,
    val total_pages: String,
    val total_results: String
)