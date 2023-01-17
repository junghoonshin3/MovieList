package com.sjh.data.remote.model

data class NaverMovieList(
    val lastBuildDate: String,
    val total: String,
    val start: String,
    val display: String,
    val items: List<NaverMovie>
)