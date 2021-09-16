package com.example.cleanarchitecture.viewmodel

import com.example.domain.entity.CharacterData
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CharacterInformationViewModelTest : BaseViewModelTest() {

    private lateinit var viewModel: CharacterInformationViewModel
    private val characterData: CharacterData = mock()
    private val successResponse: FragmentData = FragmentData(responseType = FragmentStatus.INITIALIZATION, data = characterData)
    private val failureResponse: FragmentData =
        FragmentData(responseType = FragmentStatus.INITIALIZATION_EMPTY_DESCRIPTION, data = characterData)

    @Before
    override fun `set up`() {
        super.`set up`()
        viewModel = CharacterInformationViewModel()
    }

    @Test
    fun `show character information initialization`() {
        val liveDataUnderTest = viewModel.getLiveDataState().testObserver()
        whenever(characterData.description).thenReturn(DESCRIPTION)

        viewModel.showCharacterInformation(characterData)

        assertEquals(successResponse.responseType, liveDataUnderTest.observedValues[FIRST_RESPONSE]?.peekContent()?.responseType)
        assertEquals(successResponse.data, liveDataUnderTest.observedValues[FIRST_RESPONSE]?.peekContent()?.data)
    }

    @Test
    fun `show character information initialization empty description`() {
        val liveDataUnderTest = viewModel.getLiveDataState().testObserver()
        whenever(characterData.description).thenReturn(EMPTY_DESCRIPTION)

        viewModel.showCharacterInformation(characterData)

        assertEquals(failureResponse.responseType, liveDataUnderTest.observedValues[FIRST_RESPONSE]?.peekContent()?.responseType)
        assertEquals(failureResponse.data, liveDataUnderTest.observedValues[FIRST_RESPONSE]?.peekContent()?.data)
    }

    companion object {
        private const val DESCRIPTION = "Something"
        private const val EMPTY_DESCRIPTION = ""
        private const val FIRST_RESPONSE: Int = 0
    }
}
