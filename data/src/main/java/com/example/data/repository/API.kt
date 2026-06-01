package com.example.data.repository

import com.example.codingclinic10.com.example.domain.model.Model1
import retrofit2.http.GET
import retrofit2.http.POST

interface API {

    @GET("users")
    suspend fun getInfo() : List<Model1>

    @POST("users")
    suspend fun sendInfo() : Model1

}