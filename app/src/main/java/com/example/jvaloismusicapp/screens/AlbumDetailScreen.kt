package com.example.jvaloismusicapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jvaloismusicapp.components.ASongCard
import com.example.jvaloismusicapp.components.AlbumHeader
import com.example.jvaloismusicapp.components.RPSongCard
import com.example.jvaloismusicapp.models.AlbumByIdModel
import com.example.jvaloismusicapp.models.AlbumModel
import com.example.jvaloismusicapp.routes.AlbumDetailRoute
import com.example.jvaloismusicapp.services.AlbumService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

@Composable
fun AlbumDetailScreen(id : String, pv : PaddingValues){
    val url = "https://music.juanfrausto.com/api/"
    var album by remember {
        mutableStateOf<AlbumByIdModel?>(null)
    }
    var loading by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(true) {
        try {
            Log.i("AlbumDetailScreen", "Creando la instancia de retrofit")
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(AlbumService::class.java)
            Log.i("AlbumDetailScreen", "ID: ${id}")
            val result = withContext(Dispatchers.IO){
                service.getAlbumById(id)
            }
            Log.i("AlbumDetailScreen", "Response: ${result}")
            album = result
            loading = false
        } catch (e: Exception) {
            Log.e("AlbumDetailScreen", "Algo fallo: ${e.message}")
            loading = false
        }
    }
    if (loading) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        val tracks = List(10) { index ->
            album?.copy(title = "${album?.title} Track ${index + 1}") // opcional cambiar título
        }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 25.dp)
                .padding(horizontal = 20.dp)
        ) {
            album?.let { nonNullAlbum ->
                AlbumHeader(album = nonNullAlbum)
            }
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Black)
            ){ // Sobre este album
                Column (
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                        .fillMaxWidth()
                ){
                    Text(
                        "Sobre este album",
                        color = Color.Black,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        album?.description ?: "null",
                        color = Color.Gray,
                        fontSize = 20.sp
                    )
                }
            }
            Box (
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .clip(RoundedCornerShape(35.dp))
                    .background(Color.Black)
            ){ // Artista
                Row (
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                ){
                    Text(
                        "Artista: ",
                        color = Color.Black,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        album?.artist ?: "null",
                        color = Color.Gray,
                        fontSize = 19.sp
                    )
                }
            }
            Box {
                LazyColumn {  // Lista de canciones del album  (Lista con la misma cancion + "Track n")
                    items(tracks) { track ->
                        ASongCard(
                            album = track,
                            num = 1
                        )
                    }
                }
                // !! Insertar popup de reproducción
            }
        }
    }
}