package com.sjh.movielist.di

import com.sjh.data.remote.MovieRepositoryImpl
import com.sjh.data.remote.api.MovieService
import com.sjh.data.remote.source.MovieDatabase
import com.sjh.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Provides
    fun provideMovieRepository(
        movieService: MovieService,
//        movieDatabase: MovieDatabase
    ): MovieRepository = MovieRepositoryImpl(
        movieService,
//        movieDatabase
    )
}