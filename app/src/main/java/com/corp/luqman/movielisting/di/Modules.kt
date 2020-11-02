package com.corp.luqman.movielisting.di


import com.corp.luqman.movielisting.data.database.MovieDatabase
import com.corp.luqman.movielisting.data.remote.ApiService
import com.corp.luqman.movielisting.data.remote.createWebService
import com.corp.luqman.movielisting.data.remote.provideOkHttpClient
import com.corp.luqman.movielisting.data.repository.MoviesRepository
import com.corp.luqman.movielisting.ui.fragment.*
import com.corp.luqman.movielisting.utils.Const
import com.corp.luqman.movielisting.utils.rx.AppSchedulerProvider
import com.corp.luqman.movielisting.utils.rx.SchedulerProvider
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    single { provideOkHttpClient(androidContext()) }
    single { createWebService<ApiService>(get(), Const.appUrl) }
    single { AppSchedulerProvider() as SchedulerProvider }
    single { MovieDatabase.getInstance(androidContext())}
}

val dataModule = module {
    single { MoviesRepository(get(), get()) }
}

val viewModelModule = module {

    viewModel {
        MoviesPopularViewModel(
            get(),
            get()
        )
    }
    viewModel {
        MoviesNowPlayingViewModel(
            get(),
            get()
        )
    }
    viewModel {
        MoviesUpcomingViewModel(
            get(),
            get()
        )
    }
    viewModel {
        DetailMovieViewModel(
            get(),
            get()
        )
    }
    viewModel {
        ReviewMovieViewModel(
            get(),
            get()
        )
    }
}

val myAppModule = listOf(
    appModule,
    dataModule,
    viewModelModule
)
