package com.example.domain.entity

data class CharacterDataWrapperEntity(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val data: CharacterDataContainerEntity,
    val etag: String
)
