package com.sjh.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BoxOfficeResult(
    val boxOfficeResult : BoxOffice
) : Parcelable