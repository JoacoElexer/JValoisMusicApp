package com.example.jvaloismusicapp.models

import kotlinx.serialization.Serializable

@Serializable
data class AlbumByIdModel(
    val title: String,
    val artist: String,
    val description: String,
    val image: String,
    val _id: String
)
