package com.corp.luqman.movielisting.data.remote.response

import com.corp.luqman.movielisting.data.models.Movie
import com.corp.luqman.movielisting.data.models.Review
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReviewMovieResponse(
    @Json(name = "page")
    var page : Int? = 0,
    @Json(name = "vote_count")
    var total_results : Int? = 0,
    @Json(name = "total_results")
    var total_pages : Int? = 0,
    @Json(name = "results")
    var results: MutableList<Review>?
)