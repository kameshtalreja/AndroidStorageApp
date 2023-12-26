package com.kamesh.composesetup.domain.repository

import com.kamesh.composesetup.data.remote.dto.ArticalsDTO

interface ArticlesRepository {

    suspend fun getArticles(apiKey : String) : ArticalsDTO
}