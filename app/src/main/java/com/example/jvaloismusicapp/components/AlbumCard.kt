package com.example.jvaloismusicapp.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.jvaloismusicapp.R
import com.example.jvaloismusicapp.models.AlbumModel

@Composable
fun AlbumCard(
    album: AlbumModel,
    onClick: () -> Unit
){
    Box ( // Main container
        modifier = Modifier
            .clickable {
                onClick()
            }
            .padding(top = 14.dp)
            .padding(horizontal = 10.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color.Black)
            .height(185.dp)
            .width(225.dp),
        contentAlignment = Alignment.BottomCenter
    ){ // "BG" img
        AsyncImage(
            model = album.image,
            contentDescription = album.title,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(25.dp)),
            contentScale = ContentScale.Crop
        )
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Magenta)
                .height(55.dp),
            contentAlignment = Alignment.Center
        ){ // Info container
            Row (
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Column {
                    Text(
                        album.title,
                        fontSize = 17.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        album.artist,
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
                HorizontalDivider(modifier = Modifier.weight(1f), color = Color.Transparent)
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(3.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(Color.White)
                        .size(30.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.playicon),
                        contentDescription = "Play",
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
            }
        }
    }
}