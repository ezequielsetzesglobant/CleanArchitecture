package com.example.cleanarchitecture.viewmodel

import com.example.domain.entity.CharacterData
import com.example.domain.entity.CharacterDataContainerData
import com.example.domain.entity.CharacterDataWrapperData
import com.example.domain.repository.CharacterRepository
import com.example.domain.usecase.CharacterUseCase
import com.example.domain.usecase.CharacterUseCaseImpl
import com.example.domain.utils.Result
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CharacterViewModelTest : BaseViewModelTest() {

    private lateinit var viewModel: CharacterViewModel
    private lateinit var useCase: CharacterUseCase
    private val characterRepository: CharacterRepository = mock()
    private val characterDataWrapperDataValidResult: Result.Success<CharacterDataWrapperData> = mock()
    private val characterDataWrapperDataInvalidResult: Result.Failure = mock()
    private val characterDataWrapperData: CharacterDataWrapperData = mock()
    private val exception: Exception = mock()
    private val characterDataContainerData: CharacterDataContainerData = mock()
    private val characters: MutableList<CharacterData> = mock()
    private val successResponseList: List<Data> =
        listOf(Data(responseType = Status.LOADING), Data(responseType = Status.SUCCESSFUL, data = characterDataWrapperData))
    private val emptyListResponseList: List<Data> =
        listOf(Data(responseType = Status.LOADING), Data(responseType = Status.EMPTY_LIST, error = NO_CHARACTERS_MESSAGE))
    private val failureResponseList: List<Data> =
        listOf(Data(responseType = Status.LOADING), Data(responseType = Status.ERROR, error = EXCEPTION_MESSAGE))

    @Before
    override fun `set up`() {
        super.`set up`()
        useCase = CharacterUseCaseImpl(characterRepository)
        viewModel = CharacterViewModel(useCase)
    }

    @Test
    fun `fetch characters test successful`() {
        val liveDataUnderTest = viewModel.getLiveDataState().testObserver()
        whenever(characterRepository.getInformationApi()).thenReturn(characterDataWrapperDataValidResult)
        whenever(characterDataWrapperDataValidResult.data).thenReturn(characterDataWrapperData)
        whenever(characterDataWrapperData.data).thenReturn(characterDataContainerData)
        whenever(characterDataContainerData.results).thenReturn(characters)

        runBlocking {
            viewModel.fetchCharacters().join()
        }

        verify(characterRepository).getInformationApi()
        assertEquals(
            successResponseList[FIRST_RESPONSE].responseType,
            liveDataUnderTest.observedValues[FIRST_RESPONSE]?.peekContent()?.responseType
        )
        assertEquals(
            successResponseList[SECOND_RESPONSE].responseType,
            liveDataUnderTest.observedValues[SECOND_RESPONSE]?.peekContent()?.responseType
        )
        assertEquals(successResponseList[SECOND_RESPONSE].data, liveDataUnderTest.observedValues[SECOND_RESPONSE]?.peekContent()?.data)
    }

    @Test
    fun `fetch characters test empty list`() {
        val liveDataUnderTest = viewModel.getLiveDataState().testObserver()
        whenever(characterRepository.getInformationApi()).thenReturn(characterDataWrapperDataValidResult)
        whenever(characterDataWrapperDataValidResult.data).thenReturn(characterDataWrapperData)
        whenever(characterDataWrapperData.data).thenReturn(characterDataContainerData)
        whenever(characterDataContainerData.results).thenReturn(emptyList())

        runBlocking {
            viewModel.fetchCharacters().join()
        }

        verify(characterRepository).getInformationApi()
        assertEquals(
            emptyListResponseList[FIRST_RESPONSE].responseType,
            liveDataUnderTest.observedValues[FIRST_RESPONSE]?.peekContent()?.responseType
        )
        assertEquals(
            emptyListResponseList[SECOND_RESPONSE].responseType,
            liveDataUnderTest.observedValues[SECOND_RESPONSE]?.peekContent()?.responseType
        )
        assertEquals(emptyListResponseList[SECOND_RESPONSE].error, liveDataUnderTest.observedValues[SECOND_RESPONSE]?.peekContent()?.error)
    }

    @Test
    fun `fetch characters test error`() {
        val liveDataUnderTest = viewModel.getLiveDataState().testObserver()
        whenever(characterRepository.getInformationApi()).thenReturn(characterDataWrapperDataInvalidResult)
        whenever(characterDataWrapperDataInvalidResult.exception).thenReturn(exception)
        whenever(exception.message).thenReturn(EXCEPTION_MESSAGE)

        runBlocking {
            viewModel.fetchCharacters().join()
        }

        verify(characterRepository).getInformationApi()
        assertEquals(
            failureResponseList[FIRST_RESPONSE].responseType,
            liveDataUnderTest.observedValues[FIRST_RESPONSE]?.peekContent()?.responseType
        )
        assertEquals(
            failureResponseList[SECOND_RESPONSE].responseType,
            liveDataUnderTest.observedValues[SECOND_RESPONSE]?.peekContent()?.responseType
        )
        assertEquals(failureResponseList[SECOND_RESPONSE].error, liveDataUnderTest.observedValues[SECOND_RESPONSE]?.peekContent()?.error)
    }

    companion object {
        private const val EXCEPTION_MESSAGE: String = "Request error"
        private const val NO_CHARACTERS_MESSAGE: String = "No characters found"
        private const val FIRST_RESPONSE: Int = 0
        private const val SECOND_RESPONSE: Int = 1
    }
}
