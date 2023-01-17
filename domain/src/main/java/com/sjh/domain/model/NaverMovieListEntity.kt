package com.sjh.domain.model

data class NaverMovieListEntity(
    val lastBuildDate: String,
    val total: String,
    val start: String,
    val display: String,
    val items: List<NaverMovieEntity>
)