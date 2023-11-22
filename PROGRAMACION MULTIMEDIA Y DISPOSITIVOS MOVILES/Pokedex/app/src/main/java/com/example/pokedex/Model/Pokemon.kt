package com.example.pokedex.Model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("id")
    val id: String,
    @SerializedName("sprites/")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("types")
    val primaryType: String,
    val secondaryType: String,
    @SerializedName("weight")
    val weight: Float,
    @SerializedName("height")
    val height: Float,
    @SerializedName("stats")
    val stats: Map<String, Int>
)
