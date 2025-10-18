package com.example.jvaloismusicapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
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
import com.example.jvaloismusicapp.models.AlbumByIdModel
import com.example.jvaloismusicapp.models.AlbumModel

@Composable
fun ASongCard(
    album: AlbumByIdModel?,
    num: Int
){
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color.LightGray)
            .height(75.dp),
        contentAlignment = Alignment.Center
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
        ){
            AsyncImage(
                album?.image,
                contentDescription = album?.title,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(55.dp),
                contentScale = ContentScale.Crop
            )
            Column (
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            ){
                Text(
                    album?.title ?: "null",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    album?.artist ?: "null",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
            HorizontalDivider(modifier = Modifier.weight(1f), color = Color.Transparent)
            Image(
                painter = painterResource(id = R.drawable.verticaldotsdark),
                contentDescription = "Options",
                modifier = Modifier
                    .size(25.dp)
            )
        }
    }
}