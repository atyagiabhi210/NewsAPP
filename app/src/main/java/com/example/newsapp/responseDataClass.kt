package com.example.newsapp

data class responseDataClass(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)