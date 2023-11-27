package com.example.pokedex.View

import Pokemon
import Types
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.pokedex.ViewModel.InfoPokemonViewModel
import com.example.pokedex.ui.theme.Purple40
import java.time.format.TextStyle

class InfoPokemonView {
    @Composable
    fun InfoPokemon(infoPokemonViewModel: InfoPokemonViewModel) {
        val pokemon by infoPokemonViewModel.pokemon.observeAsState()
        infoPokemonViewModel.getPokemon(LocalContext.current)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            pokemon?.let { TopBar(it) }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(225.dp)
                    .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))
                    .background(Purple40),
                contentAlignment = Alignment.Center
            ) {
                pokemon?.let { Image(
                    painter = rememberAsyncImagePainter(model = it.sprites.other.officialArtwork.frontDefault),
                    contentDescription = it.id,
                    contentScale = ContentScale.Crop,
                ) }
            }
            pokemon?.let { Text(
                text = it.name,
                fontSize = 40.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(20.dp)
            ) }
            val sizeTypes = pokemon?.types?.size
//            Row {
//                for (i in 0 until sizeTypes!!) {
//                    Box(
//                        modifier = Modifier
//                            .width(120.dp)
//                            .height(30.dp)
//                            .clip(
//                                RoundedCornerShape(
//                                    bottomStart = 50.dp,
//                                    bottomEnd = 50.dp,
//                                    topStart = 50.dp,
//                                    topEnd = 50.dp
//                                )
//                            )
//                            .background(Purple40)
//                    ) {
//                        pokemon?.let { Text(
//                            text = it.types[0].type.name,
//                            fontSize = 40.sp,
//                            color = Color.White,
//                            modifier = Modifier
//                                .padding(20.dp)
//                        ) }
//                    }
//                    Spacer(modifier = Modifier.width(25.dp))
//                }
//            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(pokemon: Pokemon) {
    TopAppBar(
        title = { Text(
            text = "Pokedex",
            color = Color.White,
        ) },
        modifier = Modifier
            .fillMaxWidth(),
        navigationIcon = {
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "ArrowBack",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(Purple40),
        actions = {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "#${pokemon.id}",
                    color = Color.White
                )
            }
        }
    )
}