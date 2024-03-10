package com.shnayder.android.wewatch.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponse(
    @Json(name = "Search")
    val items: List<Film>?,
)