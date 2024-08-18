package com.rishi.basesetup.data.sources.remote

import com.rishi.basesetup.data.AppApiClientService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ExampleRemoteDataSource @Inject constructor(
    private val service: AppApiClientService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    fun getExampleData(
        country: String,
        apiKey: String
    ) = flow {
        val response = service.getExampleData(country, apiKey)
        emit(response)
    }.flowOn(dispatcher)
}