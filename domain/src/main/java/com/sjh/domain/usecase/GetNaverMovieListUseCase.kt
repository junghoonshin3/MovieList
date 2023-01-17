package com.sjh.domain.usecase

import com.sjh.domain.repository.MovieRepository
import javax.inject.Inject

class GetNaverMovieListUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(title:String) = repository.getNaverMovieList(title)

}