package com.example.cleanarchitecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.utils.Event
import com.example.domain.entity.CharacterDataWrapperEntity
import com.example.domain.usecase.CharacterUseCase
import com.example.domain.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CharacterViewModel(private val characterUseCase: CharacterUseCase) : ViewModel() {

    private var mutableCharactersState: MutableLiveData<Event<Data<CharacterDataWrapperEntity>>> = MutableLiveData()
    val liveDataState: LiveData<Event<Data<CharacterDataWrapperEntity>>>
        get() = mutableCharactersState

    fun onFetchCharactersClicked() {
        viewModelScope.launch {
            mutableCharactersState.value = Event(Data(responseType = Status.LOADING))
            when (val result = withContext(Dispatchers.IO) { characterUseCase() }) {
                is Result.Success -> {
                    mutableCharactersState.value = Event(Data(responseType = Status.SUCCESSFUL, data = result.data))
                }
                is Result.Failure -> {
                    mutableCharactersState.value = Event(Data(responseType = Status.ERROR, error = result.exception))
                }
            }
        }

    }
}

data class Data<RequestData>(var responseType: Status, var data: RequestData? = null, var error: Exception? = null)

enum class Status { SUCCESSFUL, ERROR, LOADING }
