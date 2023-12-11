package com.example.pokedex.data.repositories

import com.example.pokedex.data.models.PokemonListResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonListRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val pokeApiService = retrofit.create(PokeApiService::class.java)

    suspend fun getPokemonList(): List<PokemonListResponse> {
        return pokeApiService.getPokemonList()
    }
}