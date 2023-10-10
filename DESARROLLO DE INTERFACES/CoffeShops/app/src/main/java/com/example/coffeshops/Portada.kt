package com.example.coffeshops

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeshops.ui.theme.Pink100
import com.example.coffeshops.ui.theme.Pink300
import com.example.coffeshops.ui.theme.alviaregular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Portada(navController: NavController) {
    var showMenu by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = { Text(text = "Coffee") },
            modifier = Modifier
                .fillMaxWidth(),
            navigationIcon = {
                IconButton(
                    onClick = { /*TODO*/ },
                ) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu",
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(Pink300),
            actions = {
                IconButton(
                    onClick = { showMenu = !showMenu },
                ) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "MoreVert",
                    )
                }
                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false },
                    Modifier.width(150.dp)
                ) {
                    DropdownMenuItem(
                        onClick = { showMenu },
                        text = { Text(text = "Compartir") },
                        leadingIcon = { Icon(imageVector = Icons.Filled.Share, contentDescription = "Compartir") }
                    )
                    DropdownMenuItem(
                        onClick = { showMenu },
                        text = { Text(text = "Álbum") },
                        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Álbum") }
                    )
                }
            }
        )
        MyCards()
    }
}

@Composable
fun MyCards() {
    val dataShops = listOf(
        DataShops(R.drawable.images, "Antico Coffe Greco", "St. Italy, Rome"),
        DataShops(R.drawable.images1, "Coffee Room", "St. Germany, Berlin"),
        DataShops(R.drawable.images2, "Coffe Ibiza", "St. Colon, Madrid"),
        DataShops(R.drawable.images3, "Pudding Coffe Shop", "St. Diagonal, Barcelona"),
        DataShops(R.drawable.images4, "L'Express", "St. Picadilly Circus, London"),
        DataShops(R.drawable.images5, "Coffe Corner", "St. Àngel Guimerà, Valencia"),
        DataShops(R.drawable.images6, "Sweet Cup", "St. Kinkerstraat, Amsterdam")
    )

    var estado = 0.0

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {
            items(dataShops) { data ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    colors = CardDefaults.cardColors(Pink100)
                ) {
                    Image(
                        painter = painterResource(id = data.image),
                        contentDescription = data.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .height(200.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = data.title,
                        fontSize = 25.sp,
                        fontFamily = alviaregular,
                        modifier = Modifier.padding(10.dp)
                    )
                    RatingBar(
                        rating = estado,
                        onRatingChanged = { newRating ->
                            estado = newRating
                        },
                        modifier = Modifier.padding(10.dp)
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = data.direction,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                    Divider()
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color.Transparent)
                    ) {
                        Text(
                            text = "RESERVE",
                            color = Color.Magenta
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    starsColor: Color = Color.Red,
    onRatingChanged: (Double) -> Unit
) {
    var estadoRating by remember { mutableStateOf(rating) }

    Row(
        modifier = modifier,
    ) {
        for (i in 1..stars) {
            val filled = i <= estadoRating
            Icon(
                imageVector = if (filled) Icons.Filled.Star else Icons.Outlined.Star,
                contentDescription = null,
                tint = if (filled) starsColor else Color.Gray,
                modifier = Modifier.clickable {
                    estadoRating = i.toDouble()
                    onRatingChanged(estadoRating)
                }
            )
            Spacer(modifier = Modifier.width(13.dp))
        }
    }
}