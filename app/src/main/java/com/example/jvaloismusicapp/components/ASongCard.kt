package com.example.jvaloismusicapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.jvaloismusicapp.R
import com.example.jvaloismusicapp.models.AlbumModel

@Composable
fun ASongCard(
    album: AlbumModel,
    num: Int
){
    Box (
        modifier = Modifier
            .padding(top = 16.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color.Gray)
    ){
        Row {
            AsyncImage(
                album.image,
                contentDescription = album.title
            )
            Column {
                Text("${album.title} • Track ${num}")
                Text(album.artist)
            }
            HorizontalDivider(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.verticaldotsdark),
                contentDescription = "Options"
            )
        }
    }
}