package com.example.jvaloismusicapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AlbumDetailScreen(id : String, pv : PaddingValues){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(pv)
    ){
        // !! Insertar componente de album grande
        Box { // Sobre este album

        }
        Box { // Artista

        }
        LazyColumn { // Lista de canciones del album  (Lista con la misma cancion + "Track n")

        }
    }
}