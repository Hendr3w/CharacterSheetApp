package com.example.charactersheetapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import races.Human
import races.Race
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun CharacterAttributesScreen(character: Tav, onCharacterSaved: (Tav) -> Unit) {
    // Aplicar bônus da raça ao personagem
    character.strength.updateAtribute()
    character.dexterity.updateAtribute()
    character.constituition.updateAtribute()
    character.wisdom.updateAtribute()
    character.intelligence.updateAtribute()
    character.charisma.updateAtribute()

    // Atualiza a raça do personagem
    when (character.raceName) {
        "Humano" -> character.changeRace(Human())
        // Adicione outras raças conforme necessário
        else -> character.changeRace(Human()) // Raça padrão
    }

    character.applyRaceStatus()

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

        // Botão para salvar o personagem
        Button(
            onClick = { onCharacterSaved(character) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Salvar Personagem")
        }
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
    CharacterAttributesScreen(character, onCharacterSaved = {})
}
