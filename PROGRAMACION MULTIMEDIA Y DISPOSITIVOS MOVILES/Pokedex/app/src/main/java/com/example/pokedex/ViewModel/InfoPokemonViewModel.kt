package com.example.pokedex.ViewModel

import Pokemon
import android.app.Application
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedex.Data.Repository.InfoPokemonRespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale

class InfoPokemonViewModel(application: Application): AndroidViewModel(application) {

    private var _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    init {
        getPokemon()
    }

    val infoPokemonRespository = InfoPokemonRespository(application)
    fun getPokemon() {
        viewModelScope.launch {
            val loadedPokemon = withContext(Dispatchers.IO) {
                infoPokemonRespository.getPokemon()
            }
            _pokemon.postValue(loadedPokemon)
        }

    }

//    fun getTypeColor(typeColor: String): Color {
//        when (typeColor) {
//            "normal" -> return normalColor
//            "fire" -> return fireColor
//            "water" -> return waterColor
//            "electric" -> return electricColor
//            "grass" -> return grassColor
//            "ice" -> return iceColor
//            "fighting" -> return fightingColor
//            "poison" -> return poisonColor
//            "ground" -> return groundColor
//            "flying" -> return flyingColor
//            "psychic" -> return psychicColor
//            "bug" -> return bugColor
//            "rock" -> return rockColor
//            "ghost" -> return ghostColor
//            "dragon" -> return dragonColor
//            "dark" -> return darkColor
//            "steel" -> return steelColor
//            "fairy" -> return fairyColor
//            else -> return Color.Black
//        }
//    }

    val mapTypecolors = infoPokemonRespository.colorTypes()
    fun getTypeColor(type: String): Color? {
        val typeColor = mapTypecolors[type.lowercase(Locale.ROOT)]
        return typeColor?.color
    }
}