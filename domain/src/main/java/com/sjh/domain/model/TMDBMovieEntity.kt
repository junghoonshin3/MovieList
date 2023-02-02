package com.sjh.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TMDBMovieEntity(
    val adult: Boolean,
    val backdrop_path: String?="",
    val genre_ids: List<Int>,
    val id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: String,
    val vote_count: String,
) : Parcelable