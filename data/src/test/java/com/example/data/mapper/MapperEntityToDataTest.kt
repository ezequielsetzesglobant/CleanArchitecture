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
import io.realm.RealmList
import java.util.Date
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MapperEntityToDataTest {

    @Test
    fun `CharacterDataWrapperEntity transform to CharacterDataWrapperData`() {
        val characterDataWrapperData: CharacterDataWrapperData = characterDataWrapperEntity.transformEntityToData()
        assertEquals(INT_DEFAULT, characterDataWrapperData.code)
        assertEquals(STRING_DEFAULT, characterDataWrapperData.status)
        assertEquals(STRING_DEFAULT, characterDataWrapperData.copyright)
        assertEquals(STRING_DEFAULT, characterDataWrapperData.attributionText)
        assertEquals(STRING_DEFAULT, characterDataWrapperData.attributionHTML)
        assertEquals(STRING_DEFAULT, characterDataWrapperData.etag)
    }

    @Test
    fun `CharacterDataContainerEntity transform to CharacterDataContainerData`() {
        val characterDataContainerData: CharacterDataContainerData = characterDataWrapperEntity.transformEntityToData().data
        assertEquals(INT_DEFAULT, characterDataContainerData.offset)
        assertEquals(INT_DEFAULT, characterDataContainerData.limit)
        assertEquals(INT_DEFAULT, characterDataContainerData.total)
        assertEquals(INT_DEFAULT, characterDataContainerData.count)
    }

    @Test
    fun `CharacterEntity transform to CharacterData`() {
        val characterData: CharacterData = characterDataWrapperEntity.transformEntityToData().data.results.first()
        assertEquals(INT_DEFAULT, characterData.id)
        assertEquals(STRING_DEFAULT, characterData.name)
        assertEquals(STRING_DEFAULT, characterData.description)
        assertEquals(STRING_DEFAULT, characterData.resourceURI)
    }

    @Test
    fun `UrlEntity transform to UrlData`() {
        val urlData: UrlData = characterDataWrapperEntity.transformEntityToData().data.results.first().urls.first()
        assertEquals(STRING_DEFAULT, urlData.type)
        assertEquals(STRING_DEFAULT, urlData.url)
    }

    @Test
    fun `ImageEntity transform to ImageData`() {
        val imageData: ImageData = characterDataWrapperEntity.transformEntityToData().data.results.first().thumbnail
        assertEquals(STRING_DEFAULT, imageData.path)
        assertEquals(STRING_DEFAULT, imageData.extension)
    }

    @Test
    fun `ComicListEntity transform to ComicListData`() {
        val comicListData: ComicListData = characterDataWrapperEntity.transformEntityToData().data.results.first().comics
        assertEquals(INT_DEFAULT, comicListData.available)
        assertEquals(INT_DEFAULT, comicListData.returned)
        assertEquals(STRING_DEFAULT, comicListData.collectionURI)
    }

    @Test
    fun `ComicSummaryEntity transform to ComicSummaryData`() {
        val comicSummaryData: ComicSummaryData =
            characterDataWrapperEntity.transformEntityToData().data.results.first().comics.items.first()
        assertEquals(STRING_DEFAULT, comicSummaryData.resourceURI)
        assertEquals(STRING_DEFAULT, comicSummaryData.name)
    }

    @Test
    fun `StoryListEntity transform to StoryListData`() {
        val storyListData: StoryListData = characterDataWrapperEntity.transformEntityToData().data.results.first().stories
        assertEquals(INT_DEFAULT, storyListData.available)
        assertEquals(INT_DEFAULT, storyListData.returned)
        assertEquals(STRING_DEFAULT, storyListData.collectionURI)
    }

    @Test
    fun `StorySummaryEntity transform to StorySummaryData`() {
        val storySummaryData: StorySummaryData =
            characterDataWrapperEntity.transformEntityToData().data.results.first().stories.items.first()
        assertEquals(STRING_DEFAULT, storySummaryData.resourceURI)
        assertEquals(STRING_DEFAULT, storySummaryData.name)
        assertEquals(STRING_DEFAULT, storySummaryData.type)
    }

    @Test
    fun `EventListEntity transform to EventListData`() {
        val eventListData: EventListData = characterDataWrapperEntity.transformEntityToData().data.results.first().events
        assertEquals(INT_DEFAULT, eventListData.available)
        assertEquals(INT_DEFAULT, eventListData.returned)
        assertEquals(STRING_DEFAULT, eventListData.collectionURI)
    }

    @Test
    fun `EventSummaryEntity transform to EventSummaryData`() {
        val eventSummaryData: EventSummaryData =
            characterDataWrapperEntity.transformEntityToData().data.results.first().events.items.first()
        assertEquals(STRING_DEFAULT, eventSummaryData.resourceURI)
        assertEquals(STRING_DEFAULT, eventSummaryData.name)
    }

    @Test
    fun `SeriesListEntity transform to SeriesListData`() {
        val seriesListData: SeriesListData = characterDataWrapperEntity.transformEntityToData().data.results.first().series
        assertEquals(INT_DEFAULT, seriesListData.available)
        assertEquals(INT_DEFAULT, seriesListData.returned)
        assertEquals(STRING_DEFAULT, seriesListData.collectionURI)
    }

    @Test
    fun `SeriesSummaryEntity transform to SeriesSummaryData`() {
        val seriesSummaryData: SeriesSummaryData =
            characterDataWrapperEntity.transformEntityToData().data.results.first().series.items.first()
        assertEquals(STRING_DEFAULT, seriesSummaryData.resourceURI)
        assertEquals(STRING_DEFAULT, seriesSummaryData.name)
    }

    companion object ConstantUtils {
        private const val INT_DEFAULT: Int = 0
        private const val STRING_DEFAULT: String = "nothing"
        private val seriesSummaryEntity: SeriesSummaryEntity = SeriesSummaryEntity(
            resourceURI = STRING_DEFAULT,
            name = STRING_DEFAULT
        )
        private val seriesListEntity: SeriesListEntity = SeriesListEntity(
            available = INT_DEFAULT,
            returned = INT_DEFAULT,
            collectionURI = STRING_DEFAULT,
            items = RealmList(seriesSummaryEntity)
        )
        private val eventSummaryEntity: EventSummaryEntity = EventSummaryEntity(
            resourceURI = STRING_DEFAULT,
            name = STRING_DEFAULT
        )
        private val eventListEntity: EventListEntity = EventListEntity(
            available = INT_DEFAULT,
            returned = INT_DEFAULT,
            collectionURI = STRING_DEFAULT,
            items = RealmList(eventSummaryEntity)
        )
        private val storySummaryEntity: StorySummaryEntity = StorySummaryEntity(
            resourceURI = STRING_DEFAULT,
            name = STRING_DEFAULT,
            type = STRING_DEFAULT
        )
        private val storyListEntity: StoryListEntity = StoryListEntity(
            available = INT_DEFAULT,
            returned = INT_DEFAULT,
            collectionURI = STRING_DEFAULT,
            items = RealmList(storySummaryEntity)
        )
        private val comicSummaryEntity: ComicSummaryEntity = ComicSummaryEntity(
            resourceURI = STRING_DEFAULT,
            name = STRING_DEFAULT
        )
        private val comicListEntity: ComicListEntity = ComicListEntity(
            available = INT_DEFAULT,
            returned = INT_DEFAULT,
            collectionURI = STRING_DEFAULT,
            items = RealmList(comicSummaryEntity)
        )
        private val imageEntity: ImageEntity = ImageEntity(
            path = STRING_DEFAULT,
            extension = STRING_DEFAULT
        )
        private val urlEntity: UrlEntity = UrlEntity(
            type = STRING_DEFAULT,
            url = STRING_DEFAULT
        )
        private val characterEntity: CharacterEntity = CharacterEntity(
            id = INT_DEFAULT,
            name = STRING_DEFAULT,
            description = STRING_DEFAULT,
            modified = Date(),
            resourceURI = STRING_DEFAULT,
            urls = RealmList(urlEntity),
            thumbnail = imageEntity,
            comics = comicListEntity,
            stories = storyListEntity,
            events = eventListEntity,
            series = seriesListEntity
        )
        private val characterDataContainerEntity: CharacterDataContainerEntity = CharacterDataContainerEntity(
            offset = INT_DEFAULT,
            limit = INT_DEFAULT,
            total = INT_DEFAULT,
            count = INT_DEFAULT,
            results = RealmList(characterEntity)
        )
        private val characterDataWrapperEntity: CharacterDataWrapperEntity = CharacterDataWrapperEntity(
            code = INT_DEFAULT,
            status = STRING_DEFAULT,
            copyright = STRING_DEFAULT,
            attributionText = STRING_DEFAULT,
            attributionHTML = STRING_DEFAULT,
            data = characterDataContainerEntity,
            etag = STRING_DEFAULT
        )
    }
}
