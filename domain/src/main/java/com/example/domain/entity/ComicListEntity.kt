package com.example.domain.entity

data class ComicListEntity(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<ComicSummaryEntity>,
)
