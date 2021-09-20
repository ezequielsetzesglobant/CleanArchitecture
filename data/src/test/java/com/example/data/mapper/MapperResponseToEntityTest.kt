package com.example.data.mapper

import com.example.data.database.entity.CharacterDataWrapperEntity
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
import java.util.Date
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MapperResponseToEntityTest {

    @Test
    fun `CharacterDataWrapperResponse transform to CharacterDataWrapperEntity`() {
        val characterDataWrapperData: CharacterDataWrapperEntity = characterDataWrapperResponse.transformResponseToEntity()
        assertEquals(INT_DEFAULT, characterDataWrapperData.code)
        assertEquals(STRING_DEFAULT, characterDataWrapperData.status)
        assertEquals(STRING_DEFAULT, characterDataWrapperData.copyright)
        assertEquals(STRING_DEFAULT, characterDataWrapperData.attributionText)
        assertEquals(STRING_DEFAULT, characterDataWrapperData.attributionHTML)
        assertEquals(STRING_DEFAULT, characterDataWrapperData.etag)
    }

    @Test
    fun `CharacterDataContainerResponse transform to CharacterDataContainerEntity`() {
        characterDataWrapperResponse.transformResponseToEntity().data?.let {
            assertEquals(INT_DEFAULT, it.offset)
            assertEquals(INT_DEFAULT, it.limit)
            assertEquals(INT_DEFAULT, it.total)
            assertEquals(INT_DEFAULT, it.count)
        }
    }

    @Test
    fun `CharacterResponse transform to CharacterEntity`() {
        characterDataWrapperResponse.transformResponseToEntity().data?.results?.first()?.let {
            assertEquals(INT_DEFAULT, it.id)
            assertEquals(STRING_DEFAULT, it.name)
            assertEquals(STRING_DEFAULT, it.description)
            assertEquals(STRING_DEFAULT, it.resourceURI)
        }
    }

    @Test
    fun `UrlResponse transform to UrlEntity`() {
        characterDataWrapperResponse.transformResponseToEntity().data?.results?.first()?.urls?.first()?.let {
            assertEquals(STRING_DEFAULT, it.type)
            assertEquals(STRING_DEFAULT, it.url)
        }
    }

    @Test
    fun `ImageResponse transform to ImageEntity`() {
        characterDataWrapperResponse.transformResponseToEntity().data?.results?.first()?.thumbnail?.let {
            assertEquals(STRING_DEFAULT, it.path)
            assertEquals(STRING_DEFAULT, it.extension)
        }
    }

    @Test
    fun `ComicListResponse transform to ComicListEntity`() {
        characterDataWrapperResponse.transformResponseToEntity().data?.results?.first()?.comics?.let {
            assertEquals(INT_DEFAULT, it.available)
            assertEquals(INT_DEFAULT, it.returned)
            assertEquals(STRING_DEFAULT, it.collectionURI)
        }
    }

    @Test
    fun `ComicSummaryResponse transform to ComicSummaryEntity`() {
        characterDataWrapperResponse.transformResponseToEntity().data?.results?.first()?.comics?.items?.first()?.let {
            assertEquals(STRING_DEFAULT, it.resourceURI)
            assertEquals(STRING_DEFAULT, it.name)
        }
    }

    @Test
    fun `StoryListResponse transform to StoryListEntity`() {
        characterDataWrapperResponse.transformResponseToEntity().data?.results?.first()?.stories?.let {
            assertEquals(INT_DEFAULT, it.available)
            assertEquals(INT_DEFAULT, it.returned)
            assertEquals(STRING_DEFAULT, it.collectionURI)
        }
    }

    @Test
    fun `StorySummaryResponse transform to StorySummaryEntity`() {
        characterDataWrapperResponse.transformResponseToEntity().data?.results?.first()?.stories?.items?.first()?.let {
            assertEquals(STRING_DEFAULT, it.resourceURI)
            assertEquals(STRING_DEFAULT, it.name)
            assertEquals(STRING_DEFAULT, it.type)
        }
    }

    @Test
    fun `EventListResponse transform to EventListEntity`() {
        characterDataWrapperResponse.transformResponseToEntity().data?.results?.first()?.events?.let {
            assertEquals(INT_DEFAULT, it.available)
            assertEquals(INT_DEFAULT, it.returned)
            assertEquals(STRING_DEFAULT, it.collectionURI)
        }
    }

    @Test
    fun `EventSummaryResponse transform to EventSummaryEntity`() {
        characterDataWrapperResponse.transformResponseToEntity().data?.results?.first()?.events?.items?.first()?.let {
            assertEquals(STRING_DEFAULT, it.resourceURI)
            assertEquals(STRING_DEFAULT, it.name)
        }
    }

    @Test
    fun `SeriesListResponse transform to SeriesListEntity`() {
        characterDataWrapperResponse.transformResponseToEntity().data?.results?.first()?.series?.let {
            assertEquals(INT_DEFAULT, it.available)
            assertEquals(INT_DEFAULT, it.returned)
            assertEquals(STRING_DEFAULT, it.collectionURI)
        }
    }

    @Test
    fun `SeriesSummaryResponse transform to SeriesSummaryData`() {
        characterDataWrapperResponse.transformResponseToEntity().data?.results?.first()?.series?.items?.first()?.let {
            assertEquals(STRING_DEFAULT, it.resourceURI)
            assertEquals(STRING_DEFAULT, it.name)
        }
    }

    companion object ConstantUtils {
        private const val INT_DEFAULT: Int = 0
        private const val STRING_DEFAULT: String = "nothing"
        private val seriesSummaryResponse: SeriesSummaryResponse = SeriesSummaryResponse(
            resourceURI = STRING_DEFAULT,
            name = STRING_DEFAULT
        )
        private val seriesListResponse: SeriesListResponse = SeriesListResponse(
            available = INT_DEFAULT,
            returned = INT_DEFAULT,
            collectionURI = STRING_DEFAULT,
            items = listOf(seriesSummaryResponse)
        )
        private val eventSummaryResponse: EventSummaryResponse = EventSummaryResponse(
            resourceURI = STRING_DEFAULT,
            name = STRING_DEFAULT
        )
        private val eventListResponse: EventListResponse = EventListResponse(
            available = INT_DEFAULT,
            returned = INT_DEFAULT,
            collectionURI = STRING_DEFAULT,
            items = listOf(eventSummaryResponse)
        )
        private val storySummaryResponse: StorySummaryResponse = StorySummaryResponse(
            resourceURI = STRING_DEFAULT,
            name = STRING_DEFAULT,
            type = STRING_DEFAULT
        )
        private val storyListResponse: StoryListResponse = StoryListResponse(
            available = INT_DEFAULT,
            returned = INT_DEFAULT,
            collectionURI = STRING_DEFAULT,
            items = listOf(storySummaryResponse)
        )
        private val comicSummaryResponse: ComicSummaryResponse = ComicSummaryResponse(
            resourceURI = STRING_DEFAULT,
            name = STRING_DEFAULT
        )
        private val comicListResponse: ComicListResponse = ComicListResponse(
            available = INT_DEFAULT,
            returned = INT_DEFAULT,
            collectionURI = STRING_DEFAULT,
            items = listOf(comicSummaryResponse)
        )
        private val imageResponse: ImageResponse = ImageResponse(
            path = STRING_DEFAULT,
            extension = STRING_DEFAULT
        )
        private val urlResponse: UrlResponse = UrlResponse(
            type = STRING_DEFAULT,
            url = STRING_DEFAULT
        )
        private val characterResponse: CharacterResponse = CharacterResponse(
            id = INT_DEFAULT,
            name = STRING_DEFAULT,
            description = STRING_DEFAULT,
            modified = Date(),
            resourceURI = STRING_DEFAULT,
            urls = listOf(urlResponse),
            thumbnail = imageResponse,
            comics = comicListResponse,
            stories = storyListResponse,
            events = eventListResponse,
            series = seriesListResponse
        )
        private val characterDataContainerResponse: CharacterDataContainerResponse = CharacterDataContainerResponse(
            offset = INT_DEFAULT,
            limit = INT_DEFAULT,
            total = INT_DEFAULT,
            count = INT_DEFAULT,
            results = listOf(characterResponse)
        )
        private val characterDataWrapperResponse: CharacterDataWrapperResponse = CharacterDataWrapperResponse(
            code = INT_DEFAULT,
            status = STRING_DEFAULT,
            copyright = STRING_DEFAULT,
            attributionText = STRING_DEFAULT,
            attributionHTML = STRING_DEFAULT,
            data = characterDataContainerResponse,
            etag = STRING_DEFAULT
        )
    }
}
