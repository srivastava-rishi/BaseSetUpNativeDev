package com.rishi.basesetup.data

import com.rishi.basesetup.data.models.ExampleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AppApiClientService {

    @GET(PATH_EXAMPLE_DATA)
    suspend fun getExampleData(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Response<ExampleResponse>

    companion object {
        // ******** - Example Path- ******** //
        private const val PATH_EXAMPLE_DATA = "top-headlines"
    }
}