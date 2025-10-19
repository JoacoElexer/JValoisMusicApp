package com.example.jvaloismusicapp.components

import android.R.attr.onClick
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
import com.example.jvaloismusicapp.ViewModels.PlayingViewModel
import com.example.jvaloismusicapp.ui.theme.playingBG

@Composable
fun PlayingCard(
    pvm : PlayingViewModel
){
    val Playing = pvm.currentlyPlaying
    if (Playing == null) {
        return
    }
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(playingBG)
            .height(75.dp),
        contentAlignment = Alignment.Center
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            AsyncImage(
                Playing.image,
                contentDescription = Playing.title,
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
                    Playing.title,
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    "${Playing.artist} • Popular Song",
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
            HorizontalDivider(modifier = Modifier.weight(1f), color = Color.Transparent)
            Image(
                painter = painterResource(id = R.drawable.playiconlight),
                contentDescription = "Options",
                modifier = Modifier
                    .size(25.dp)
            )
        }
    }
}