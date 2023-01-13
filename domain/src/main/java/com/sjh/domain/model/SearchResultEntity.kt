package com.sjh.domain.model

data class SearchResultEntity(
    val lastBuildDate: String,
    val total: String,
    val start: String,
    val display: String,
    val items: List<MovieEntity>
)