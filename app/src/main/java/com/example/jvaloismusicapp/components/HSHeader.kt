package com.example.jvaloismusicapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.request.colorSpace
import com.example.jvaloismusicapp.R

@Composable
fun HSHeader(){
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 15.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color.Gray)
    ){
        Column (
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 20.dp)
        ){
            Row (
                modifier = Modifier
                    .padding(bottom = 20.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.listlight),
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(25.dp)
                )
                HorizontalDivider(modifier = Modifier
                    .weight(1f),
                    color = Color.Transparent
                )
                Image(
                    painter = painterResource(id = R.drawable.magnifyingglasslight),
                    contentDescription = "Search",
                    modifier = Modifier
                        .size(25.dp)
                )
            }
            Text(
                "Bienvenido de nuevo!",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(bottom = 7.dp)
            )
            Text(
                "Joaquín Valois",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HSHeaderPreview(){
    HSHeader()
}