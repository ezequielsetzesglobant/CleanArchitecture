package com.example.domain.entity

data class EventListEntity(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<EventSummaryEntity>,
)
