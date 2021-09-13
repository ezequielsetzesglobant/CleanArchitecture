package com.example.data.mapper

import com.example.data.database.entity.CharacterDataContainerEntity
import com.example.data.database.entity.CharacterDataWrapperEntity
import com.example.data.database.entity.CharacterEntity
import com.example.data.database.entity.ComicListEntity
import com.example.data.database.entity.ComicSummaryEntity
import com.example.data.database.entity.EventListEntity
import com.example.data.database.entity.EventSummaryEntity
import com.example.data.database.entity.ImageEntity
import com.example.data.database.entity.SeriesListEntity
import com.example.data.database.entity.SeriesSummaryEntity
import com.example.data.database.entity.StoryListEntity
import com.example.data.database.entity.StorySummaryEntity
import com.example.data.database.entity.UrlEntity
import com.example.domain.entity.CharacterData
import com.example.domain.entity.CharacterDataContainerData
import com.example.domain.entity.CharacterDataWrapperData
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

fun CharacterDataWrapperEntity.transformEntityToData() = CharacterDataWrapperData(
    code = this.code,
    status = this.status,
    copyright = this.copyright,
    attributionText = this.attributionText,
    attributionHTML = this.attributionHTML,
    data = this.data?.transformEntityToData() ?: CharacterDataContainerData(),
    etag = this.etag
)

private fun CharacterDataContainerEntity.transformEntityToData() = CharacterDataContainerData(
    offset = this.offset,
    limit = this.limit,
    total = this.total,
    count = this.count,
    results = this.results.mapTo(mutableListOf(), { it.transformEntityToData() })
)

private fun CharacterEntity.transformEntityToData() = CharacterData(
    id = this.id,
    name = this.name,
    description = this.description,
    modified = this.modified,
    resourceURI = this.resourceURI,
    urls = this.urls.map { it.transformEntityToData() },
    thumbnail = this.thumbnail?.transformEntityToData() ?: ImageData(),
    comics = this.comics?.transformEntityToData() ?: ComicListData(),
    stories = this.stories?.transformEntityToData() ?: StoryListData(),
    events = this.events?.transformEntityToData() ?: EventListData(),
    series = this.series?.transformEntityToData() ?: SeriesListData()
)

private fun UrlEntity.transformEntityToData() = UrlData(
    type = this.type,
    url = this.url
)

private fun ImageEntity.transformEntityToData() = ImageData(
    path = this.path,
    extension = this.extension
)

private fun ComicListEntity.transformEntityToData() = ComicListData(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.mapTo(mutableListOf(), { it.transformEntityToData() })
)

private fun ComicSummaryEntity.transformEntityToData() = ComicSummaryData(
    resourceURI = this.resourceURI,
    name = this.name
)

private fun StoryListEntity.transformEntityToData() = StoryListData(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.mapTo(mutableListOf(), { it.transformEntityToData() })
)

private fun StorySummaryEntity.transformEntityToData() = StorySummaryData(
    resourceURI = this.resourceURI,
    name = this.name,
    type = this.type
)

private fun EventListEntity.transformEntityToData() = EventListData(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.mapTo(mutableListOf(), { it.transformEntityToData() })
)

private fun EventSummaryEntity.transformEntityToData() = EventSummaryData(
    resourceURI = this.resourceURI,
    name = this.name
)

private fun SeriesListEntity.transformEntityToData() = SeriesListData(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.mapTo(mutableListOf(), { it.transformEntityToData() })
)

private fun SeriesSummaryEntity.transformEntityToData() = SeriesSummaryData(
    resourceURI = this.resourceURI,
    name = this.name
)
