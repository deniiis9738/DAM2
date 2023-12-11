package com.example.pokedex.views

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.pokedex.viewmodels.PokemonListViewModel

class PokemonListView {
    @Composable
    fun PokemonList(pokemonListViewModel: PokemonListViewModel) {
        val pokemonList by pokemonListViewModel.pokemonList.observeAsState()

        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(pokemonList) { pokemon ->
                Text(text = pokemon)
            }
        }
    }
}