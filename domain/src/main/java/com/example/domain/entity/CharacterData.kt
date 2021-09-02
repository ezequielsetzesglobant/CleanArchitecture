package com.example.domain.entity

import com.example.domain.utils.ConstantUtils
import java.util.Date

data class CharacterData(
    val id: Int = ConstantUtils.INT_DEFAULT,
    val name: String = ConstantUtils.STRING_DEFAULT,
    val description: String = ConstantUtils.STRING_DEFAULT,
    val modified: Date = Date(),
    val resourceURI: String = ConstantUtils.STRING_DEFAULT,
    val urls: List<UrlData> = emptyList(),
    val thumbnail: ImageData = ImageData(),
    val comics: ComicListData = ComicListData(),
    val stories: StoryListData = StoryListData(),
    val events: EventListData = EventListData(),
    val series: SeriesListData = SeriesListData(),
)
