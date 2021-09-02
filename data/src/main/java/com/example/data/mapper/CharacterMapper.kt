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
import com.example.domain.entity.CharacterDataContainerEntity
import com.example.domain.entity.CharacterDataWrapperEntity
import com.example.domain.entity.CharacterEntity
import com.example.domain.entity.ComicListEntity
import com.example.domain.entity.ComicSummaryEntity
import com.example.domain.entity.EventListEntity
import com.example.domain.entity.EventSummaryEntity
import com.example.domain.entity.ImageEntity
import com.example.domain.entity.SeriesListEntity
import com.example.domain.entity.SeriesSummaryEntity
import com.example.domain.entity.StoryListEntity
import com.example.domain.entity.StorySummaryEntity
import com.example.domain.entity.UrlEntity

fun CharacterDataWrapperResponse.transform() = CharacterDataWrapperEntity(
    code = this.code,
    status = this.status,
    copyright = this.copyright,
    attributionText = this.attributionText,
    attributionHTML = this.attributionHTML,
    data = this.data.transform(),
    etag = this.etag
)

private fun CharacterDataContainerResponse.transform() = CharacterDataContainerEntity(
    offset = this.offset,
    limit = this.limit,
    total = this.total,
    count = this.count,
    results = this.results.map { it.transform() }
)

private fun CharacterResponse.transform() = CharacterEntity(
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

private fun UrlResponse.transform() = UrlEntity(
    type = this.type,
    url = this.url
)

private fun ImageResponse.transform() = ImageEntity(
    path = this.path,
    extension = this.extension
)

private fun ComicListResponse.transform() = ComicListEntity(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.map { it.transform() }
)

private fun ComicSummaryResponse.transform() = ComicSummaryEntity(
    resourceURI = this.resourceURI,
    name = this.name
)

private fun StoryListResponse.transform() = StoryListEntity(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.map { it.transform() }
)

private fun StorySummaryResponse.transform() = StorySummaryEntity(
    resourceURI = this.resourceURI,
    name = this.name,
    type = this.type
)

private fun EventListResponse.transform() = EventListEntity(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.map { it.transform() }
)

private fun EventSummaryResponse.transform() = EventSummaryEntity(
    resourceURI = this.resourceURI,
    name = this.name
)

private fun SeriesListResponse.transform() = SeriesListEntity(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.map { it.transform() }
)

private fun SeriesSummaryResponse.transform() = SeriesSummaryEntity(
    resourceURI = this.resourceURI,
    name = this.name
)
