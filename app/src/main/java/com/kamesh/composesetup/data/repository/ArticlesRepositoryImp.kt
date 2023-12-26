package com.kamesh.composesetup.data.repository

import com.kamesh.composesetup.data.remote.MovieDBApi
import com.kamesh.composesetup.data.remote.dto.ArticalsDTO
import com.kamesh.composesetup.domain.repository.ArticlesRepository
import javax.inject.Inject

class ArticlesRepositoryImp @Inject constructor(private val movieDBApi: MovieDBApi) : ArticlesRepository {

    override suspend fun getArticles(apiKey : String): ArticalsDTO {
        return movieDBApi.getArticles(apiKey)
    }

}


