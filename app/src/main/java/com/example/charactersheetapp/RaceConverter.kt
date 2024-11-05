package com.example.charactersheetapp

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import races.Race

class RaceConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromRace(race: Race?): String {
        return gson.toJson(race) // Armazena a instância como JSON
    }

    @TypeConverter
    fun toRace(raceString: String): Race? {
        val type = object : TypeToken<Race>() {}.type
        return gson.fromJson(raceString, type)
    }
}
