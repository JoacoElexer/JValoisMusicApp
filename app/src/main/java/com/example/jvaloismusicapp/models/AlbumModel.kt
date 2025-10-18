package com.example.jvaloismusicapp.models

import kotlinx.serialization.Serializable

@Serializable
data class AlbumModel(
    val title: String,
    val artist: String,
    val description: String,
    val imageUrl: String,
    val id: String
)
