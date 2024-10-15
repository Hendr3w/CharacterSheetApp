package com.example.charactersheetapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import races.*;
import androidx.compose.runtime.*


@Composable
fun CharacterAttributesScreen(character: Tav) {
    val currentRaceName by remember { derivedStateOf { character.raceName } }
    // Aplicar bônus da raça ao personagem

    character.strength.updateAtribute()
    character.dexterity.updateAtribute()
    character.constituition.updateAtribute()
    character.wisdom.updateAtribute()
    character.intelligence.updateAtribute()
    character.charisma.updateAtribute()

    when (character.raceName) {
        "Humano" -> character.changeRace(Human())
        "Elfo" -> character.changeRace(Elf())
        "Anão" -> character.changeRace(Dwarf())
        "Drow" -> character.changeRace(Drow())
        "Meio-Elfo" -> character.changeRace(HalfElf())
        "Halfling" -> character.changeRace(Halfling())
        "Meio-Orc" -> character.changeRace(HalfOrc())
        "Tiefling" -> character.changeRace(Tiefling())
        else -> character.changeRace(Human()) // Raça padrão
    }

    character.strength.updateAtribute()
    character.dexterity.updateAtribute()
    character.constituition.updateAtribute()
    character.wisdom.updateAtribute()
    character.intelligence.updateAtribute()
    character.charisma.updateAtribute()



    character.applyRaceStatus()


    LaunchedEffect(character) {
        when (character.raceName) {
            "Humano" -> character.changeRace(Human())
            "Elfo" -> character.changeRace(Elf())
            "Anão" -> character.changeRace(Dwarf())
            "Drow" -> character.changeRace(Drow())
            "Meio-Elfo" -> character.changeRace(HalfElf())
            "Halfling" -> character.changeRace(Halfling())
            "Meio-Orc" -> character.changeRace(HalfOrc())
            "Tiefling" -> character.changeRace(Tiefling())
            else -> character.changeRace(Human()) // Raça padrão
        }

        character.name = "Chegamos AQUI"

        character.applyRaceStatus()
    }

    // Calcular HP
    val hp = remember { character.health + character.constituition.mod }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Atributos do Personagem", style = MaterialTheme.typography.headlineMedium)

        // Exibir nome e raça do personagem
        Text(text = "Nome: ${character.name}", style = MaterialTheme.typography.titleLarge)
        Text(text = "Raça: ${character.raceName}", style = MaterialTheme.typography.titleMedium)

        // Exibir atributos
        AtributeRow(attribute = character.strength)
        AtributeRow(attribute = character.dexterity)
        AtributeRow(attribute = character.constituition)
        AtributeRow(attribute = character.intelligence)
        AtributeRow(attribute = character.wisdom)
        AtributeRow(attribute = character.charisma)

        // Exibir HP
        Text(text = "HP: $hp", style = MaterialTheme.typography.titleMedium)
    }
}

@Composable
fun AtributeRow(attribute: Atribute) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "${attribute.name}: ${attribute.value}", modifier = Modifier.weight(1f))
        Text(text = "Mod: ${attribute.mod}", modifier = Modifier.padding(start = 8.dp))
        Text(text = "Custo: ${attribute.cost}", modifier = Modifier.padding(start = 8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterAttributesScreen() {
    val character = Tav(name = "Aragorn", raceName = "Humano") // Crie um personagem para a pré-visualização
    CharacterAttributesScreen(character)
}
