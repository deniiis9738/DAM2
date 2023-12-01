package com.example.pokedex.Data.Repository

import Pokemon
import android.app.Application
import com.example.pokedex.Data.Model.TypeColor
import com.google.gson.Gson

class InfoPokemonRespository(val application: Application) {

    fun getPokemon(): Pokemon {
        val gson = Gson()
        val jsonInputStream = application.assets.open("ditto.json")

        return gson.fromJson(jsonInputStream.reader(), Pokemon::class.java)
    }

    fun colorTypes(): HashMap<String, TypeColor> {
        return hashMapOf(
            "normal" to TypeColor.NORMAL,
            "fire" to TypeColor.FIRE,
            "water" to TypeColor.WATER,
            "electric" to TypeColor.ELECTRIC,
            "grass" to TypeColor.GRASS,
            "ice" to TypeColor.ICE,
            "fighting" to TypeColor.FIGHTING,
            "poison" to TypeColor.POISON,
            "ground" to TypeColor.GROUND,
            "flying" to TypeColor.FLYING,
            "psychic" to TypeColor.PSYCHIC,
            "bug" to TypeColor.BUG,
            "rock" to TypeColor.ROCK,
            "ghost" to TypeColor.GHOST,
            "dragon" to TypeColor.DRAGON,
            "dark" to TypeColor.DARK,
            "steel" to TypeColor.STEEL,
            "fairy" to TypeColor.FAIRY,
        )
    }
}