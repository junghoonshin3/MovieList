package com.sjh.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BoxOffice(
    val boxofficeType: String,
    val showRange: String,
    val dailyBoxOfficeList: List<Movie>
) : Parcelable