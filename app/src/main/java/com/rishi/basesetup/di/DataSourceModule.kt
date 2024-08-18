package com.rishi.basesetup.di

import com.rishi.basesetup.data.AppApiClientService
import com.rishi.basesetup.data.sources.remote.ExampleRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun exampleRemoteDataSource(
        service: AppApiClientService
    ) = ExampleRemoteDataSource(service)
}