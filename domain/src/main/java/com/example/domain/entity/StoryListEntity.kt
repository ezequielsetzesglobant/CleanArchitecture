package com.example.domain.entity

data class StoryListEntity(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<StorySummaryEntity>,
)
