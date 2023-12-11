package com.example.pokedex.data.models

import com.google.gson.annotations.SerializedName

data class PokemonList(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

data class PokemonListResponse(
    @SerializedName("results")
    val results: PokemonList
)