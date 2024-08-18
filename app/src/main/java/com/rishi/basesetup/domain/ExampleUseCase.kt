package com.rishi.basesetup.domain

import com.rishi.basesetup.data.repositories.ExampleRepository
import javax.inject.Inject


class ExampleUseCase @Inject constructor(val repository: ExampleRepository) {
    operator fun invoke(country: String, apiKey: String) =
        repository.getExampleData(country, apiKey)
}