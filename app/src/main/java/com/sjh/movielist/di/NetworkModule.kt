package com.sjh.movielist.di

import com.sjh.data.remote.api.MovieService
import com.sjh.movielist.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl() = "https://openapi.naver.com/v1/search"

    @Singleton
    @Provides
    fun provideOkHttpClient() = OkHttpClient.Builder().run {
        val interceptor = AppInterceptor()
        addInterceptor(interceptor)
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(provideBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieService(retrofit: Retrofit): MovieService =
        retrofit.create(MovieService::class.java)

    class AppInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
            val newRequest =
                request().newBuilder().addHeader("X-Naver-Client-Id", "${R.string.client_id}")
                    .addHeader("X-Naver-Client-Secret", "${R.string.client_secret}")
                    .build()
            proceed(newRequest)
        }
    }



}