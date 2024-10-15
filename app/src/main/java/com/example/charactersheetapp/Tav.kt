package com.example.charactersheetapp

import races.Human
import races.Race

import androidx.compose.runtime.mutableStateOf

class Tav(
    var name: String = "",
    var level: Int = 1,
    var raceName: String = "Humano",
    var speed: Float = 9.0f, // Meters
    var health: Int = 10,
    var strength: Atribute = Atribute("Força"),
    var dexterity: Atribute = Atribute("Destreza"),
    var constituition: Atribute = Atribute("Constituição"),
    var wisdom: Atribute = Atribute("Sabedoria"),
    var intelligence: Atribute = Atribute("Inteligência"),
    var charisma: Atribute = Atribute("Carisma"),
    var race: Race = Human(),
    var nightVision: Int = 0,  // Meters
    var statusPoints: Int = 27
) {

    fun changeRace(newRace: Race) {
        this.race = newRace
    }

    fun applyRaceStatus() {
        this.race.RaceStatus(this)
    }

    fun calculateStatusPointsRemaining(): Int {
        val totalCost = strength.cost + dexterity.cost + constituition.cost +
                wisdom.cost + intelligence.cost + charisma.cost
        return 27 - totalCost
    }
}
