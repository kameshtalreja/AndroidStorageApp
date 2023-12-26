package com.kamesh.composesetup.presentation.HomeScreen

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kamesh.composesetup.Resources
import com.kamesh.composesetup.data.remote.dto.Result
import com.kamesh.composesetup.domain.useCase.articleUsecase.ArticleUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val articleUsecase: ArticleUsecase
) : ViewModel() {

    private  val TAG = "HomeViewModel"

    val _articlesList : MutableStateFlow<List<Result>> = MutableStateFlow(emptyList<Result>())
    val articlesList = _articlesList.asStateFlow()

    init {
        getArticles()
    }
    fun getArticles(){
        articleUsecase().onEach { result->
            when(result){
                is Resources.Success -> {

                    Log.d(TAG, "getArticles: result.data!!")
                    _articlesList.value = result.data!!

                }
                is Resources.Error -> {
                    Log.d(TAG, "getArticles: ${result.message}")
                }
                is Resources.Loading -> {
                    Log.d(TAG, "getArticles: Loading")
                }
            }
        }.launchIn(viewModelScope)
    }
}


