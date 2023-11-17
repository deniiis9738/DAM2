package com.example.pokedex.View

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.pokedex.InfoPokemonViewModel

class InfoPokemonView {
    @Composable
    fun InfoPokemon(infoPokemonViewModel: InfoPokemonViewModel) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Ditto")
        }
    }
}