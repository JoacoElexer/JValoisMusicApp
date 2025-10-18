package com.example.jvaloismusicapp.routes

import kotlinx.serialization.Serializable


@Serializable
object HomeScreenRoute

@Serializable
data class AlbumDetailRoute(val id: String)