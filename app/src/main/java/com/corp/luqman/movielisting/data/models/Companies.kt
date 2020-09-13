package com.corp.luqman.movielisting.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Companies (
    @Json(name = "id")
    var id : Long? = 0,
    @Json(name = "logo_path")
    var logo_path : String? = "",
    @Json(name = "name")
    var name : String? = "",
    @Json(name = "origin_country")
    var origin_country : String? = ""
)