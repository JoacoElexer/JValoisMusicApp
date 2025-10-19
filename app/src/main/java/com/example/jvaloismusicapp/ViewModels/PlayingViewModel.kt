package com.example.jvaloismusicapp.ViewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.jvaloismusicapp.models.AlbumModel

class PlayingViewModel : ViewModel(){
    private val PlayingNow = mutableStateOf<AlbumModel?>(null)
    val currentlyPlaying: AlbumModel?
        get() = PlayingNow.value
    fun onAlbumSelected(album: AlbumModel) {
        PlayingNow.value = album
    }
}