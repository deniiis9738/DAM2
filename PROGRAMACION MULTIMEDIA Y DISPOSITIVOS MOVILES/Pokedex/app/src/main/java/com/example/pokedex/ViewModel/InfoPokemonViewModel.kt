package com.example.pokedex.ViewModel

import Pokemon
import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.Model.InfoPokemonModel
import com.example.pokedex.ui.theme.bugColor
import com.example.pokedex.ui.theme.darkColor
import com.example.pokedex.ui.theme.dragonColor
import com.example.pokedex.ui.theme.electricColor
import com.example.pokedex.ui.theme.fairyColor
import com.example.pokedex.ui.theme.fightingColor
import com.example.pokedex.ui.theme.fireColor
import com.example.pokedex.ui.theme.flyingColor
import com.example.pokedex.ui.theme.ghostColor
import com.example.pokedex.ui.theme.grassColor
import com.example.pokedex.ui.theme.groundColor
import com.example.pokedex.ui.theme.iceColor
import com.example.pokedex.ui.theme.normalColor
import com.example.pokedex.ui.theme.poisonColor
import com.example.pokedex.ui.theme.psychicColor
import com.example.pokedex.ui.theme.rockColor
import com.example.pokedex.ui.theme.steelColor
import com.example.pokedex.ui.theme.waterColor

class InfoPokemonViewModel(private val infoPokemonModel: InfoPokemonModel): ViewModel() {

    private var _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    fun getPokemon(context: Context) {
        return _pokemon.postValue(infoPokemonModel.getPokemon(context))
    }

    fun getTypeColor(typeColor: String): Color {
        when (typeColor) {
            "normal" -> return normalColor
            "fire" -> return fireColor
            "water" -> return waterColor
            "electric" -> return electricColor
            "grass" -> return grassColor
            "ice" -> return iceColor
            "fighting" -> return fightingColor
            "poison" -> return poisonColor
            "ground" -> return groundColor
            "flying" -> return flyingColor
            "psychic" -> return psychicColor
            "bug" -> return bugColor
            "rock" -> return rockColor
            "ghost" -> return ghostColor
            "dragon" -> return dragonColor
            "dark" -> return darkColor
            "steel" -> return steelColor
            "fairy" -> return fairyColor
            else -> return Color.Black
        }
    }
}