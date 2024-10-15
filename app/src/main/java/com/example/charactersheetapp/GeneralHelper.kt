package com.example.charactersheetapp

import races.*

class GeneralHelper {
    fun showStatus(tav: Tav) {
        println("-----Seus Atributos-----")
        println("Nome: " + tav.name)
        println("Raça: " + tav.raceName)
        println("Pontos de Vida: " + tav.health)
        println("")
        println("Força: " + tav.strength)
        println("Destreza: " + tav.dexterity)
        println("Constituição: " + tav.constituition)
        println("Sabedoria: " + tav.wisdom)
        println("Inteligência: " + tav.intelligence)
        println("Carísma: " + tav.charisma)
        println(" ")
        println("Veloccidade: " + tav.speed + "m")
        println("Visão Noturna: " + tav.nightVision + "m")
    }

    fun raceSelector(tav: Tav) {

        println("-----Seleção de Raça-----")
        println("1 - Humano");
        println("2 - Elfo");
        println("3 - Anão");
        println("4 - Meio-Elfo");
        println("5 - Halfling");
        println("6 - Meio-Orc");
        println("7 - Tiefling");
        println("8 - Drow");

        var valor = readLine()!!.toInt();

        if (valor > 0 && valor < 9) {
            when (valor) {
                1 -> tav.changeRace(Human())
                2 -> tav.changeRace(Elf())
                3 -> tav.changeRace(Dwarf())
                4 -> tav.changeRace(HalfElf())
                5 -> tav.changeRace(Halfling())
                6 -> tav.changeRace(HalfOrc())
                7 -> tav.changeRace(Tiefling())
                8 -> tav.changeRace(Drow())
            }

            println("Raça Selecionada!")
            return;
        }
        println("Valor inválido");
        raceSelector(tav);
    }
}
    /*fun resetStatus(tav: Tav){
        tav.strength.value = 8;
        tav.dexterity.value = 8;
        tav.constituition.value = 8;
        tav.wisdon.value = 8;
        tav.inteligence.value = 8;
        tav.charisma.value = 8;
    }


    /*fun verifyBalance(tav : Tav, atr: Atribute) : Boolean {

        if (tav.statusPoints >= atr.costUp && atr.value < 16 && atr.value > 7)
            return true
        else
            return false;
    }

    fun calcHP(tav: Tav){
        var constMod = tav.constituition.calcMod(tav.constituition.value)
        tav.health += constMod



    }
}*/