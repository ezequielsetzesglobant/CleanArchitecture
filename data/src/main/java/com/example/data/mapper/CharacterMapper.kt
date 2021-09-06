package com.example.data.mapper

import com.example.data.response.CharacterDataContainerResponse
import com.example.data.response.CharacterDataWrapperResponse
import com.example.data.response.CharacterResponse
import com.example.data.response.ComicListResponse
import com.example.data.response.ComicSummaryResponse
import com.example.data.response.EventListResponse
import com.example.data.response.EventSummaryResponse
import com.example.data.response.ImageResponse
import com.example.data.response.SeriesListResponse
import com.example.data.response.SeriesSummaryResponse
import com.example.data.response.StoryListResponse
import com.example.data.response.StorySummaryResponse
import com.example.data.response.UrlResponse
import com.example.domain.entity.CharacterDataContainerData
import com.example.domain.entity.CharacterDataWrapperData
import com.example.domain.entity.CharacterData
import com.example.domain.entity.ComicListData
import com.example.domain.entity.ComicSummaryData
import com.example.domain.entity.EventListData
import com.example.domain.entity.EventSummaryData
import com.example.domain.entity.ImageData
import com.example.domain.entity.SeriesListData
import com.example.domain.entity.SeriesSummaryData
import com.example.domain.entity.StoryListData
import com.example.domain.entity.StorySummaryData
import com.example.domain.entity.UrlData

fun CharacterDataWrapperResponse.transform() = CharacterDataWrapperData(
    code = this.code,
    status = this.status,
    copyright = this.copyright,
    attributionText = this.attributionText,
    attributionHTML = this.attributionHTML,
    data = this.data.transform(),
    etag = this.etag
)

private fun CharacterDataContainerResponse.transform() = CharacterDataContainerData(
    offset = this.offset,
    limit = this.limit,
    total = this.total,
    count = this.count,
    results = this.results.map { it.transform() }
)

private fun CharacterResponse.transform() = CharacterData(
    id = this.id,
    name = this.name,
    description = this.description,
    modified = this.modified,
    resourceURI = this.resourceURI,
    urls = this.urls.map { it.transform() },
    thumbnail = this.thumbnail.transform(),
    comics = this.comics.transform(),
    stories = this.stories.transform(),
    events = this.events.transform(),
    series = this.series.transform()
)

private fun UrlResponse.transform() = UrlData(
    type = this.type,
    url = this.url
)

private fun ImageResponse.transform() = ImageData(
    path = this.path,
    extension = this.extension
)

private fun ComicListResponse.transform() = ComicListData(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.map { it.transform() }
)

private fun ComicSummaryResponse.transform() = ComicSummaryData(
    resourceURI = this.resourceURI,
    name = this.name
)

private fun StoryListResponse.transform() = StoryListData(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.map { it.transform() }
)

private fun StorySummaryResponse.transform() = StorySummaryData(
    resourceURI = this.resourceURI,
    name = this.name,
    type = this.type
)

private fun EventListResponse.transform() = EventListData(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.map { it.transform() }
)

private fun EventSummaryResponse.transform() = EventSummaryData(
    resourceURI = this.resourceURI,
    name = this.name
)

private fun SeriesListResponse.transform() = SeriesListData(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.map { it.transform() }
)

private fun SeriesSummaryResponse.transform() = SeriesSummaryData(
    resourceURI = this.resourceURI,
    name = this.name
)
