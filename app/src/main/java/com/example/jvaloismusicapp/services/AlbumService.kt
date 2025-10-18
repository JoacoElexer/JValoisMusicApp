package com.example.jvaloismusicapp.services

import com.example.jvaloismusicapp.models.AlbumByIdModel
import com.example.jvaloismusicapp.models.AlbumModel
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumService{
    @GET("albums/")
    suspend fun getAlbums(): List<AlbumModel>

    @GET("albums/{id}")
    suspend fun getAlbumById(@Path("id") id: String): AlbumByIdModel
}
