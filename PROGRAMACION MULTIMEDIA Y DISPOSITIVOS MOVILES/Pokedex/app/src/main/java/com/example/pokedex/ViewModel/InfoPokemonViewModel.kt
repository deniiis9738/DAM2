package com.example.pokedex.ViewModel

import Pokemon
import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.Model.InfoPokemonModel
import com.example.pokedex.View.TypeColor

class InfoPokemonViewModel(private val infoPokemonModel: InfoPokemonModel): ViewModel() {

    private var _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    fun getPokemon(context: Context) {
        return _pokemon.postValue(infoPokemonModel.getPokemon(context))
    }

    fun getTypeColor(typeColor: String): Color {
        when (typeColor) {
            "normal" -> return Color.Gray
            "fire" -> return Color.Gray
            "water" -> return Color.Gray
            "electric" -> return Color.Gray
            "grass" -> return Color.Gray
            "ice" -> return Color.Gray
            "figthing" -> return Color.Gray
            "poison" -> return Color.Gray
            "ground" -> return Color.Gray
            "flying" -> return Color.Gray
            "psychic" -> return Color.Gray
            "bug" -> return Color.Gray
            "rock" -> return Color.Gray
            "ghost" -> return Color.Gray
            "dragon" -> return Color.Gray
            "dark" -> return Color.Gray
            "steel" -> return Color.Gray
            "fairy" -> return Color.Gray
            else -> return Color.Black
        }
    }
}