package com.rishi.basesetup.data.repositories

import com.rishi.basesetup.data.models.ExampleResponse
import com.rishi.basesetup.data.sources.remote.ExampleRemoteDataSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class ExampleRepository @Inject constructor(
    private val dataSource: ExampleRemoteDataSource,
) {
    fun getExampleData(
        country: String,
        apiKey: String
    ): Flow<Response<ExampleResponse>> {
        return dataSource.getExampleData(country, apiKey)
    }
}