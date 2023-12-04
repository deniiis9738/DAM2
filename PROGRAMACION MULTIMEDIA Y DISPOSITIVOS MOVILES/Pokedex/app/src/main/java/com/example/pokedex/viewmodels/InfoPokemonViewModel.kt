package com.example.pokedex.viewmodels

import Pokemon
import android.app.Application
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.repositories.InfoPokemonRespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale

class InfoPokemonViewModel(application: Application): AndroidViewModel(application) {

    private var _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    val infoPokemonRespository = InfoPokemonRespository(application)

    init {
        getPokemon()
    }

    fun getPokemon() {
        viewModelScope.launch {
            val loadedPokemon = withContext(Dispatchers.IO) {
                infoPokemonRespository.getPokemon()
            }
            _pokemon.postValue(loadedPokemon)
        }

    }

    val mapTypeColors = infoPokemonRespository.colorTypes()
    fun getTypeColor(type: String): Color? {
        val typeColor = mapTypeColors[type.lowercase(Locale.ROOT)]
        return typeColor?.color
    }

    val mapStatsColors = infoPokemonRespository.colorStats()
    fun getStatsColor(stat: String): Color? {
        val statColor = mapStatsColors[stat.lowercase(Locale.ROOT)]
        return statColor?.color
    }
}