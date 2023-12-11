package com.example.pokedex.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.models.PokemonListResponse
import com.example.pokedex.data.repositories.PokemonListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonListViewModel: ViewModel() {
    private val pokemonListRepository = PokemonListRepository()

    private var _pokemonList = MutableLiveData<List<PokemonListResponse>>()
    val pokemonList: LiveData<List<PokemonListResponse>> = _pokemonList

    private fun getPokemonList() {
        viewModelScope.launch {
            val loadedPokemon = withContext(Dispatchers.IO) {
                pokemonListRepository.getPokemonList()
            }
            _pokemonList.postValue(loadedPokemon)
        }
    }
}