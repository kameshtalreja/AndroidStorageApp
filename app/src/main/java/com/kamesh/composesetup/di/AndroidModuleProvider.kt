package com.kamesh.composesetup.di

import com.kamesh.composesetup.data.remote.MovieDBApi
import com.kamesh.composesetup.data.repository.ArticlesRepositoryImp
import com.kamesh.composesetup.data.util.Constants
import com.kamesh.composesetup.domain.repository.ArticlesRepository
import com.kamesh.composesetup.domain.useCase.articleUsecase.ArticleUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AndroidModuleProvider {

    @Provides
    @Singleton
    fun getRepository() : String {
        return "Hello World"
    }

    @Provides
    @Singleton
    @Named("hello1")
    fun getHello1() : String {
        return "Hello World 1"
    }

    @Provides
    @Singleton
    @Named("hello2")
    fun getHello2() : String {
        return "Hello World 2"
    }

    @Provides
    @Singleton
    @Named("hello3")
    fun getHello3() : String {
        return "Hello World 3"
    }

    @Provides
    @Singleton
    @Named("hello4")
    fun getHello4() : String {
        return "Hello World 4"
    }

    @Provides
    @Singleton
    fun getApiInterface() : MovieDBApi {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()

    }


    @Provides
    @Singleton
    fun articleRepository(movieDBApi: MovieDBApi) : ArticlesRepository{
        return ArticlesRepositoryImp(movieDBApi)
    }

    @Provides
    @Singleton
    fun articleUseCase(repository: ArticlesRepository) : ArticleUsecase{
        return  ArticleUsecase(repository)
    }
}