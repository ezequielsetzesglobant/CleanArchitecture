package com.example.cleanarchitecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.utils.Event
import com.example.domain.entity.CharacterDataWrapperData
import com.example.domain.usecase.CharacterUseCase
import com.example.domain.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterViewModel(private val characterUseCase: CharacterUseCase) : ViewModel() {

    private var mutableCharactersState: MutableLiveData<Event<Data>> = MutableLiveData()

    fun getLiveDataState(): LiveData<Event<Data>> = mutableCharactersState

    fun fetchCharacters() = viewModelScope.launch {
        mutableCharactersState.postValue(Event(Data(responseType = Status.LOADING)))
        when (val result: Result<CharacterDataWrapperData> = withContext(Dispatchers.IO) { characterUseCase() }) {
            is Result.Success -> {
                if (result.data.data.results.isNotEmpty()) {
                    mutableCharactersState.postValue(Event(Data(responseType = Status.SUCCESSFUL, data = result.data)))
                } else {
                    mutableCharactersState.postValue(Event(Data(responseType = Status.EMPTY_LIST, error = NO_CHARACTERS_MESSAGE)))
                }
            }
            is Result.Failure -> {
                result.exception.message?.let {
                    mutableCharactersState.postValue(Event(Data(responseType = Status.ERROR, error = it)))
                }
            }
        }
    }

    companion object {
        private const val NO_CHARACTERS_MESSAGE: String = "No characters found"
    }
}

data class Data(
    var responseType: Status,
    var data: CharacterDataWrapperData = CharacterDataWrapperData(),
    var error: String = ERROR_DEFAULT
) {
    companion object {
        private const val ERROR_DEFAULT: String = "error default"
    }
}

enum class Status { SUCCESSFUL, ERROR, LOADING, EMPTY_LIST }
