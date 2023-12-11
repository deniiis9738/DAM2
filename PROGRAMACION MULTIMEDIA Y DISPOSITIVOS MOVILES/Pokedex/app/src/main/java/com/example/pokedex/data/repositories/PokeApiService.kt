package com.example.pokedex.data.repositories

import com.example.pokedex.data.models.Pokemon
import com.example.pokedex.data.models.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("pokemon/{id}/")
    suspend fun getPokemonById(@Path("id") id: Int): Pokemon

    @GET("pokemon/")
    suspend fun getPokemonList(): List<PokemonListResponse>
}
