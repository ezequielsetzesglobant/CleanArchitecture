package com.example.domain.entity

data class CharacterDataContainerEntity(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharacterEntity>
)
