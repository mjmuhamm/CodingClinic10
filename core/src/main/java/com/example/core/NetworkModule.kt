package com.example.core

import com.example.codingclinic10.com.example.domain.ModelRepository
import com.example.data.repository.API
import com.example.data.repository.ModelRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideAPI() = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).build().create(API::class.java)

    @Provides
    @Singleton
    fun provideRepository(val api : API) : ModelRepository = ModelRepositoryImpl(api)
}