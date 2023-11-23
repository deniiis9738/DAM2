package com.example.pokedex.ViewModel

import Pokemon
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.Model.InfoPokemonModel

class InfoPokemonViewModel(private val infoPokemonModel: InfoPokemonModel): ViewModel() {

    private var _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    fun getPokemon(context: Context) {
        return _pokemon.postValue(infoPokemonModel.getPokemon(context))
    }
}