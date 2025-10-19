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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.jvaloismusicapp.components.HSHeader
import com.example.jvaloismusicapp.models.AlbumModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.jvaloismusicapp.ViewModels.PlayingViewModel
import com.example.jvaloismusicapp.components.AlbumCard
import com.example.jvaloismusicapp.components.RPSongCard
import com.example.jvaloismusicapp.routes.AlbumDetailRoute
import com.example.jvaloismusicapp.services.AlbumService
import com.example.jvaloismusicapp.ui.theme.mainBG
import com.example.jvaloismusicapp.ui.theme.playingBG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen(navController: NavController, pv: PaddingValues, pvm: PlayingViewModel) {
    val url = "https://music.juanfrausto.com/api/"
    var albums by remember {
        mutableStateOf(listOf<AlbumModel>())
    }
    var loading by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(true) {
        try {
            Log.i("HomeScreen", "Creando la instancia de retrofit")
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(AlbumService::class.java)
            val result = withContext(Dispatchers.IO){
                service.getAlbums()
            }
            Log.i("Homescreen", "Response: ${result}")
            albums = result
            loading = false
        } catch (e: Exception) {
            Log.e("HomeScreen", "Algo fallo: ${e.message}")
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
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(mainBG)
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(pv)
                    .padding(horizontal = 20.dp)
            ){
                HSHeader()
                Row { // Titulo para albumes y boton "see more"
                    Text(
                        "Albums",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    HorizontalDivider(modifier = Modifier.weight(1f), color = Color.Transparent)
                    Text(
                        "Ver más",
                        fontSize = 17.sp,
                        color = playingBG,
                        fontWeight = FontWeight.Bold
                    )
                }
                LazyRow { // Lista de albums
                    items(albums) { album ->
                        AlbumCard(
                            album = album,
                            onClick = {
                                navController.navigate(AlbumDetailRoute(album.id))
                                pvm.onAlbumSelected(album)
                            }
                        )
                    }
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp, bottom = 10.dp)
                ){ // Titulo para reproducidos recientemente y boton "see more"
                    Text(
                        "Reproducidos recientemente",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    HorizontalDivider(modifier = Modifier.weight(1f), color = Color.Transparent)
                    Text(
                        "Ver más",
                        fontSize = 17.sp,
                        color = playingBG,
                        fontWeight = FontWeight.Bold
                    )
                }
                Box {
                    LazyColumn { // Lista de canciones
                        items(albums) { album ->
                            RPSongCard(
                                album = album,
                                onClick = {
                                    navController.navigate(AlbumDetailRoute(album.id))
                                    pvm.onAlbumSelected(album)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}