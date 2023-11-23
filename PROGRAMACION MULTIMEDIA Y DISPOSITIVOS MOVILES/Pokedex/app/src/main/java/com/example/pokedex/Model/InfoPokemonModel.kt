package com.example.pokedex.Model

import Pokemon
import android.content.Context
import com.google.gson.Gson

class InfoPokemonModel {
    fun getPokemon(context: Context): Pokemon {
        val gson = Gson()
        val jsonInputStream = context.assets.open("ditto.json")

        return gson.fromJson(jsonInputStream.reader(), Pokemon::class.java)
    }
}