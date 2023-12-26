package com.kamesh.composesetup.data.remote

import com.kamesh.composesetup.data.remote.dto.ArticalsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface  MovieDBApi {

    @GET("topstories/v2/home.json")
    suspend fun getArticles(@Query("api-key") key: String) : ArticalsDTO
}