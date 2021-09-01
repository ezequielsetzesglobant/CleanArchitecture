package com.example.domain.entity

import java.util.Date

data class CharacterEntity(
    val id: Int,
    val name: String,
    val description: String,
    val modified: Date,
    val resourceURI: String,
    val urls: List<UrlEntity>,
    val thumbnail: ImageEntity,
    val comics: ComicListEntity,
    val stories: StoryListEntity,
    val events: EventListEntity,
    val series: SeriesListEntity,
)
