package com.corp.luqman.movielisting.data.models

import androidx.room.ColumnInfo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class GenreTemp (
    @Json(name = "id")
    var id : Long = 0,
    @Json(name = "name")
    var desc : String? = "",
    @Json(name = "state")
    var state : Boolean? = false
)