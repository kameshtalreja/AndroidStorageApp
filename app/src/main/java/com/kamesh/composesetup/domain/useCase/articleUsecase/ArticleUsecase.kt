package com.kamesh.composesetup.domain.useCase.articleUsecase

import com.kamesh.composesetup.Resources
import com.kamesh.composesetup.data.remote.dto.ArticalsDTO
import com.kamesh.composesetup.data.remote.dto.Result
import com.kamesh.composesetup.data.util.Constants
import com.kamesh.composesetup.domain.repository.ArticlesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ArticleUsecase(
    private val repository: ArticlesRepository
) {

    operator fun invoke() : Flow<Resources<List<Result>>> = flow {
        try {
            val list = repository.getArticles(Constants.API_KEY)
            emit(Resources.Success(list.results))
        } catch (e : Exception){
            emit(Resources.Error(e.message))
        }
    }
}