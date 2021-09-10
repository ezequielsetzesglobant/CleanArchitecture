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
import io.realm.RealmList

fun CharacterDataWrapperResponse.transformResponseToEntity() = CharacterDataWrapperEntity(
    code = this.code,
    status = this.status,
    copyright = this.copyright,
    attributionText = this.attributionText,
    attributionHTML = this.attributionHTML,
    data = this.data.transformResponseToEntity(),
    etag = this.etag
)

private fun CharacterDataContainerResponse.transformResponseToEntity() = CharacterDataContainerEntity(
    offset = this.offset,
    limit = this.limit,
    total = this.total,
    count = this.count,
    results = this.results.mapTo(RealmList<CharacterEntity>(), { it.transformResponseToEntity() })
)

private fun CharacterResponse.transformResponseToEntity() = CharacterEntity(
    id = this.id,
    name = this.name,
    description = this.description,
    modified = this.modified,
    resourceURI = this.resourceURI,
    urls = this.urls.mapTo(RealmList<UrlEntity>(), { it.transformResponseToEntity() }),
    thumbnail = this.thumbnail.transformResponseToEntity(),
    comics = this.comics.transformResponseToEntity(),
    stories = this.stories.transformResponseToEntity(),
    events = this.events.transformResponseToEntity(),
    series = this.series.transformResponseToEntity()
)

private fun UrlResponse.transformResponseToEntity() = UrlEntity(
    type = this.type,
    url = this.url
)

private fun ImageResponse.transformResponseToEntity() = ImageEntity(
    path = this.path,
    extension = this.extension
)

private fun ComicListResponse.transformResponseToEntity() = ComicListEntity(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.mapTo(RealmList<ComicSummaryEntity>(), { it.transformResponseToEntity() })
)

private fun ComicSummaryResponse.transformResponseToEntity() = ComicSummaryEntity(
    resourceURI = this.resourceURI,
    name = this.name
)

private fun StoryListResponse.transformResponseToEntity() = StoryListEntity(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.mapTo(RealmList<StorySummaryEntity>(), { it.transformResponseToEntity() })
)

private fun StorySummaryResponse.transformResponseToEntity() = StorySummaryEntity(
    resourceURI = this.resourceURI,
    name = this.name,
    type = this.type
)

private fun EventListResponse.transformResponseToEntity() = EventListEntity(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.mapTo(RealmList<EventSummaryEntity>(), { it.transformResponseToEntity() })
)

private fun EventSummaryResponse.transformResponseToEntity() = EventSummaryEntity(
    resourceURI = this.resourceURI,
    name = this.name
)

private fun SeriesListResponse.transformResponseToEntity() = SeriesListEntity(
    available = this.available,
    returned = this.returned,
    collectionURI = this.collectionURI,
    items = this.items.mapTo(RealmList<SeriesSummaryEntity>(), { it.transformResponseToEntity() })
)

private fun SeriesSummaryResponse.transformResponseToEntity() = SeriesSummaryEntity(
    resourceURI = this.resourceURI,
    name = this.name
)
