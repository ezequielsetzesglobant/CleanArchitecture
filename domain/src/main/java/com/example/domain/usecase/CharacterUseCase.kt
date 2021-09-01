package com.example.domain.usecase

import com.example.domain.entity.CharacterDataWrapperEntity
import com.example.domain.repository.CharacterRepository
import com.example.domain.utils.Result

interface CharacterUseCase {

    operator fun invoke(): Result<CharacterDataWrapperEntity>
}

class CharacterUseCaseImpl(private val characterRepository: CharacterRepository) : CharacterUseCase {

    override operator fun invoke(): Result<CharacterDataWrapperEntity> = characterRepository.getInformationApi()
}
