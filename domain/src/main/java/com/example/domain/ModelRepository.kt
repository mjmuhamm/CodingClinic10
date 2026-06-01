package com.example.codingclinic10.com.example.domain

import com.example.codingclinic10.com.example.domain.model.Model1

interface ModelRepository {
    suspend fun getInfo() : List<Model1>
}