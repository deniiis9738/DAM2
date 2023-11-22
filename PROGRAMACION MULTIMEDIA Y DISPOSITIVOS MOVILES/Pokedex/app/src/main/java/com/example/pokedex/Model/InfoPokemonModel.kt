package com.example.pokedex.Model

import com.google.gson.Gson
import org.json.JSONObject

class InfoPokemonModel {
//    fun getJSON(): JSONObject {
//        val fileName = "ditto.json"
//        val json = Gson().fromJson(fileName, Pokemon::class.java)
//
//        return json
//    }

    fun getNamePokemon(json: JSONObject): String {
        val name = json.getString("name")

        return name
    }
}