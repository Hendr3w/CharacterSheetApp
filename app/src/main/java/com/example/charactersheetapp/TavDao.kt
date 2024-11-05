package com.example.charactersheetapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import com.google.gson.GsonBuilder
import races.Race

@Dao
interface TavDao {

    // Método para inserir um novo personagem
    @Insert
    suspend fun insert(tav: Tav)

    // Método para buscar todos os personagens
    @Query("SELECT * FROM character_table")
    suspend fun getAllTavs(): List<Tav>

    // Método para buscar um personagem por ID
    @Query("SELECT * FROM character_table WHERE id = :id")
    suspend fun getTavById(id: Int): Tav?

    // Método para atualizar um personagem existente
    @Update
    suspend fun update(tav: Tav)

    // Método para deletar um personagem
    @Delete
    suspend fun delete(tav: Tav)

    // Método para deletar todos os personagens
    @Query("DELETE FROM character_table")
    suspend fun deleteAll()

    // Método para converter Race em String
    fun convertRaceToString(race: Race): String {
        val gson = GsonBuilder()
            .registerTypeAdapter(Race::class.java, RaceTypeAdapter()) // Certifique-se de ter a classe RaceTypeAdapter
            .create()
        return gson.toJson(race)
    }

    // Método para converter String em Race
    fun convertStringToRace(raceString: String): Race {
        val gson = GsonBuilder()
            .registerTypeAdapter(Race::class.java, RaceTypeAdapter()) // Certifique-se de ter a classe RaceTypeAdapter
            .create()
        return gson.fromJson(raceString, Race::class.java)
    }
}
