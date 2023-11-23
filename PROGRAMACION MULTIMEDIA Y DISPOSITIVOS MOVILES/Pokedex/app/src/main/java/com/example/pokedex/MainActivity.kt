package com.example.pokedex

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.pokedex.Model.InfoPokemonModel
import com.example.pokedex.View.InfoPokemonView
import com.example.pokedex.ViewModel.InfoPokemonViewModel
import com.example.pokedex.ui.theme.PokedexTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    InfoPokemonView().InfoPokemon(infoPokemonViewModel = InfoPokemonViewModel(
                        InfoPokemonModel()
                    ))
                }
            }
        }
    }
}