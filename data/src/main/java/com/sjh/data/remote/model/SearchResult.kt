package com.sjh.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchResult(
    val lastBuildDate: String,
    val total: String,
    val start: String,
    val display: String,
    val items: List<Movie>
) : Parcelable