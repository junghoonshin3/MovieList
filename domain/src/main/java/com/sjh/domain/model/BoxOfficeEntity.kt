package com.sjh.domain.model

data class BoxOfficeEntity(
        val boxofficeType: String,
        val showRange: String,
        val dailyBoxOfficeList: List<MovieEntity>
)