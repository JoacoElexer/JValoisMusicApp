package com.example.jvaloismusicapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil3.compose.AsyncImage

@Composable
fun HomeScreen(navController: NavController, pv: PaddingValues) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(pv)
    ){
        Box {
            Column {
                Row {
                    // Iconos
                }
                // Bienvenida y nombre
            }
        }
        Row { // Titulo de carrusel para albumes y boton "see more"

        }
        LazyRow { // Lista de albums

        }
        Row { // Titulo de carrusel para reproducidos recientemente y boton "see more"

        }
        LazyColumn { // Lista de canciones

        }
        // !! Insertar popup de reproducción
    }
}