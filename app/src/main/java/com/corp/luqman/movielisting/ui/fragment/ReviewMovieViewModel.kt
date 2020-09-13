package com.corp.luqman.movielisting.ui.fragment

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.corp.luqman.movielisting.data.models.Movie
import com.corp.luqman.movielisting.data.models.Review
import com.corp.luqman.movielisting.data.remote.response.MoviesResponse
import com.corp.luqman.movielisting.data.remote.response.ReviewMovieResponse
import com.corp.luqman.movielisting.data.repository.MoviesRepository
import com.corp.luqman.movielisting.utils.UiState
import kotlinx.coroutines.*
import java.lang.Exception

class ReviewMovieViewModel(val moviesRepository: MoviesRepository, val context: Context) : ViewModel() {
    var isLoading = false

    fun stopLoading() {
        isLoading = false
    }

    fun startLoading(){
        isLoading = true
    }
    init {
        stopLoading()
    }
    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val scope = CoroutineScope((GlobalScope.coroutineContext))
    val reviewState = MutableLiveData<UiState<ReviewMovieResponse>>()

    val listReview : MutableList<Review> = mutableListOf()

    fun getListReview(id: String, api_key: String, page:String, language:String){
        reviewState.value = UiState.Loading()

        scope.launch {
            try {
                val result = moviesRepository.getReviewsMovie(id, api_key, page, language).await()

                listReview.addAll(result.results!!)


                reviewState.postValue(UiState.Success(result))


            }catch (e: Exception){
                reviewState.postValue(UiState.Error(e))
            }
        }
    }


}