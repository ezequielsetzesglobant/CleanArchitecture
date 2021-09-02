package com.example.domain.usecase

import com.example.domain.entity.CharacterDataWrapperData
import com.example.domain.repository.CharacterRepository
import com.example.domain.utils.Result

interface CharacterUseCase {

    operator fun invoke(): Result<CharacterDataWrapperData>
}

class CharacterUseCaseImpl(private val characterRepository: CharacterRepository) : CharacterUseCase {

    override operator fun invoke(): Result<CharacterDataWrapperData> = characterRepository.getInformationApi()
}
