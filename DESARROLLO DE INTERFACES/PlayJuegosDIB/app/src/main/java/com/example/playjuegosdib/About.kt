package com.example.playjuegosdib

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun About() {
    val context = LocalContext.current

    val dataItems = listOf(
        DataAbout(R.drawable.image1, "María Mata", "Puntos: 2014"),
        DataAbout(R.drawable.image2, "Antonio Sanz", "Puntos: 2056"),
        DataAbout(R.drawable.image3, "Carlos Pérez", "Puntos: 5231"),
        DataAbout(R.drawable.image4, "Beatriz Martos", "Puntos: 1892"),
        DataAbout(R.drawable.image5, "Carlos Hernandez", "Puntos: 6048"),
        DataAbout(R.drawable.image6, "Jose Vicente", "Puntos: 7010"),
        DataAbout(R.drawable.image7, "George Popa", "Puntos: 1967"),
        DataAbout(R.drawable.image8, "Denis Ion", "Puntos: 2240")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {
            items(dataItems) { data ->
                Row(
                    modifier = Modifier.padding(15.dp)
                    ) {
                        Image(
                            painter = painterResource(id = data.image),
                            contentDescription = null,
                            modifier = Modifier
                                .size(180.dp)
                                .clickable { Toast.makeText(context,
                                    data.name,Toast.LENGTH_SHORT).show() }
                        )
                        Spacer(modifier = Modifier.width(50.dp))
                    Column (
                        modifier = Modifier
                            .fillMaxHeight()
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = data.name,
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = data.points,
                            style = TextStyle(fontSize = 14.sp)
                        )
                    }
                }
            }
        }
    )
}