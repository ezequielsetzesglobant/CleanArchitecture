package com.example.data.response

import com.example.domain.utils.ConstantUtils
import com.google.gson.annotations.SerializedName
import java.util.Date

data class CharacterResponse(
    @SerializedName("id")
    val id: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("name")
    val name: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("description")
    val description: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("modified")
    val modified: Date = Date(),
    @SerializedName("resourceURI")
    val resourceURI: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("urls")
    val urls: List<UrlResponse> = emptyList(),
    @SerializedName("thumbnail")
    val thumbnail: ImageResponse = ImageResponse(),
    @SerializedName("comics")
    val comics: ComicListResponse = ComicListResponse(),
    @SerializedName("stories")
    val stories: StoryListResponse = StoryListResponse(),
    @SerializedName("events")
    val events: EventListResponse = EventListResponse(),
    @SerializedName("series")
    val series: SeriesListResponse = SeriesListResponse(),
)
