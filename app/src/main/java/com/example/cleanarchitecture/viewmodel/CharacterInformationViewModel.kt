package com.example.cleanarchitecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.utils.Event
import com.example.domain.entity.CharacterData

class CharacterInformationViewModel : ViewModel() {

    private var mutableComicsState: MutableLiveData<Event<FragmentData>> = MutableLiveData()

    fun getLiveDataState(): LiveData<Event<FragmentData>> = mutableComicsState

    fun showCharacterInformation(characterData: CharacterData) {
        if (characterData.description.isNotEmpty()) {
            mutableComicsState.postValue(Event(FragmentData(responseType = FragmentStatus.INITIALIZATION, data = characterData)))
        } else {
            mutableComicsState.postValue(
                Event(
                    FragmentData(
                        responseType = FragmentStatus.INITIALIZATION_EMPTY_DESCRIPTION,
                        data = characterData
                    )
                )
            )
        }
    }
}

data class FragmentData(var responseType: FragmentStatus, var data: CharacterData = CharacterData())

enum class FragmentStatus {
    INITIALIZATION, INITIALIZATION_EMPTY_DESCRIPTION
}
