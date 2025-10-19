package com.example.jvaloismusicapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
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
import com.example.jvaloismusicapp.ui.theme.playingBG

@Composable
fun FloatingPlayer(
    album : AlbumModel,
    onClick : () -> Unit
){
    Box (
        modifier = Modifier
            .clickable{
                onClick()
            }
            .padding(20.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(playingBG)
    ){
        Row {
            AsyncImage(
                album.image,
                contentDescription = album.title
            )
            Column {
                Text(album.title,
                    color = Color.White)
                Text(album.artist)
            }
            HorizontalDivider(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.playiconlight),
                contentDescription = "Play"
            )
        }
    }
}