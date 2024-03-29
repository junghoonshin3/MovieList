package com.sjh.domain.usecase

import com.sjh.domain.repository.MovieRepository
import javax.inject.Inject

class GetBoxOfficeMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke() = repository.getBoxOfficeList()

}