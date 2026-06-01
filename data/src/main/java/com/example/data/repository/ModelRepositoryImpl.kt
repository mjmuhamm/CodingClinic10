package com.example.data.repository

import com.example.codingclinic10.com.example.domain.ModelRepository
import com.example.codingclinic10.com.example.domain.model.Model1
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ModelRepositoryImpl @Inject constructor(val api: API) : ModelRepository {
    override suspend fun getInfo(): List<Model1> = withContext(Dispatchers.IO) {
        api.getInfo()
    }

}