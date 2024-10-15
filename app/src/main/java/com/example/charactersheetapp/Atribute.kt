package com.example.charactersheetapp

import kotlin.math.floor

class Atribute(
    var name: String = "",
    var value: Int = 8,
    var mod: Int = 0,
    var cost: Int = 0,
    var costUp: Int = 0
) {
    init {
        updateAtribute()
    }

    fun updateAtribute() {
        this.mod = calcMod(this.value)
        this.cost = calcCost(this.value)
        this.costUp = calcCost(this.value + 1)
    }

    fun calcCost(atributeValue: Int): Int {
        return when (atributeValue) {
            8 -> 0
            9 -> 1
            10 -> 2
            11 -> 3
            12 -> 4
            13 -> 5
            14 -> 7
            15 -> 9
            else -> Int.MAX_VALUE // Evita que atributos acima de 15 sejam aceitos
        }
    }

    fun calcMod(atributeValue: Int): Int {
        return floor((atributeValue - 10) / 2.0).toInt()
    }
}
