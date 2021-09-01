package com.example.domain.entity

data class SeriesListEntity(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<SeriesSummaryEntity>,
)
