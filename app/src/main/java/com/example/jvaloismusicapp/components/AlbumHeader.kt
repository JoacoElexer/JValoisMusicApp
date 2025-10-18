package com.example.jvaloismusicapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
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
fun AlbumHeader(
    album: AlbumByIdModel?
){
    /*Box (
        modifier = Modifier
            .padding(top = 16.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color.Gray)
    ){
        Column {

        }
        AsyncImage(
            model = album?.image,
            contentDescription = album?.title,
        )
        Box (
            modifier = Modifier
                .fillMaxSize()
        ){
            Column {
                Row {
                    Image(
                        painter = painterResource(R.drawable.arrowleftlight),
                        contentDescription = null
                    )
                    HorizontalDivider(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(R.drawable.heartlight),
                        contentDescription = null
                    )
                }
                VerticalDivider(modifier = Modifier.weight(1f))
                Text(
                    album?.title ?: "null"
                )
                Text(
                    album?.artist ?: "null"
                )
                Row {
                    Image(
                        painter = painterResource(R.drawable.playiconlight),
                        contentDescription = null
                    )
                    HorizontalDivider(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(R.drawable.shuffleicon),
                        contentDescription = null
                    )
                }
            }
        }
    }*/
    Box ( // Main container
        modifier = Modifier
            .padding(top = 14.dp, bottom = 5.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color.Black)
            .fillMaxWidth()
            .height(350.dp),
        contentAlignment = Alignment.BottomCenter
    ){ // "BG" img
        AsyncImage(
            model = album?.image,
            contentDescription = album?.title,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(25.dp)),
            contentScale = ContentScale.Crop
        )
        Box ( // Second container
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Transparent)
        ){
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 15.dp, vertical = 10.dp)
            ){
                Row {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .padding(3.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .background(Color.Black)
                            .size(50.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.arrowleftlight),
                            contentDescription = "Back",
                            modifier = Modifier
                                .size(25.dp)
                        )
                    }
                    HorizontalDivider(modifier = Modifier.weight(1f), color = Color.Transparent)
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .padding(3.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .background(Color.Black)
                            .size(50.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.heartlight),
                            contentDescription = "Favorite",
                            modifier = Modifier
                                .size(25.dp)
                        )
                    }
                }
                VerticalDivider(modifier = Modifier.weight(1f), color = Color.Transparent)
                Text(
                    album?.title ?: "null",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    album?.artist ?: "null",
                    color = Color.White,
                    fontSize = 18.sp
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                ){
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .padding(3.dp)
                            .padding(end = 10.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .background(Color.Black)
                            .size(65.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.playiconlight),
                            contentDescription = "Back",
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .padding(3.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .background(Color.White)
                            .size(65.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.shuffleicon),
                            contentDescription = "Favorite",
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                }
            }
        }
    }
}