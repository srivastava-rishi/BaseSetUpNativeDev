package com.rishi.basesetup.data.models


data class ExampleResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleData>
)

data class ArticleData(
    var id: Int? = null,
    val source: SourceData,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)

data class SourceData(
    val id: String,
    val name: String
)