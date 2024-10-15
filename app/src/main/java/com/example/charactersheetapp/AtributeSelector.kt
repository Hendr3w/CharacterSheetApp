package com.example.charactersheetapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun AttributeSelectionScreen(character: Tav, onNavigateToAttributes: () -> Unit) {
    // Estado para os pontos de status restantes
    var pointsRemaining by remember { mutableStateOf(character.calculateStatusPointsRemaining()) }

    // Atualiza os pontos restantes sempre que o personagem for modificado
    LaunchedEffect(character) {
        pointsRemaining = character.calculateStatusPointsRemaining()
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Pontos de Status Disponíveis: $pointsRemaining", fontSize = 20.sp)

        // Força
        AttributeRow(attribute = character.strength, onIncrease = {
            val costDifference = character.strength.costUp - character.strength.cost
            if (character.strength.value < 15 && costDifference <= pointsRemaining) {
                character.strength.value += 1
                character.strength.updateAtribute()
                pointsRemaining = character.calculateStatusPointsRemaining()
            }
        }, onDecrease = {
            if (character.strength.value > 8) {
                character.strength.value -= 1
                character.strength.updateAtribute()
                pointsRemaining = character.calculateStatusPointsRemaining()
            }
        })

        // Destreza
        AttributeRow(attribute = character.dexterity, onIncrease = {
            val costDifference = character.dexterity.costUp - character.dexterity.cost
            if (character.dexterity.value < 15 && costDifference <= pointsRemaining) {
                character.dexterity.value += 1
                character.dexterity.updateAtribute()
                pointsRemaining = character.calculateStatusPointsRemaining()
            }
        }, onDecrease = {
            if (character.dexterity.value > 8) {
                character.dexterity.value -= 1
                character.dexterity.updateAtribute()
                pointsRemaining = character.calculateStatusPointsRemaining()
            }
        })

        // Constituição
        AttributeRow(attribute = character.constituition, onIncrease = {
            val costDifference = character.constituition.costUp - character.constituition.cost
            if (character.constituition.value < 15 && costDifference <= pointsRemaining) {
                character.constituition.value += 1
                character.constituition.updateAtribute()
                pointsRemaining = character.calculateStatusPointsRemaining()
            }
        }, onDecrease = {
            if (character.constituition.value > 8) {
                character.constituition.value -= 1
                character.constituition.updateAtribute()
                pointsRemaining = character.calculateStatusPointsRemaining()
            }
        })

        // Sabedoria
        AttributeRow(attribute = character.wisdom, onIncrease = {
            val costDifference = character.wisdom.costUp - character.wisdom.cost
            if (character.wisdom.value < 15 && costDifference <= pointsRemaining) {
                character.wisdom.value += 1
                character.wisdom.updateAtribute()
                pointsRemaining = character.calculateStatusPointsRemaining()
            }
        }, onDecrease = {
            if (character.wisdom.value > 8) {
                character.wisdom.value -= 1
                character.wisdom.updateAtribute()
                pointsRemaining = character.calculateStatusPointsRemaining()
            }
        })

        // Inteligência
        AttributeRow(attribute = character.intelligence, onIncrease = {
            val costDifference = character.intelligence.costUp - character.intelligence.cost
            if (character.intelligence.value < 15 && costDifference <= pointsRemaining) {
                character.intelligence.value += 1
                character.intelligence.updateAtribute()
                pointsRemaining = character.calculateStatusPointsRemaining()
            }
        }, onDecrease = {
            if (character.intelligence.value > 8) {
                character.intelligence.value -= 1
                character.intelligence.updateAtribute()
                pointsRemaining = character.calculateStatusPointsRemaining()
            }
        })

        // Carisma
        AttributeRow(attribute = character.charisma, onIncrease = {
            val costDifference = character.charisma.costUp - character.charisma.cost
            if (character.charisma.value < 15 && costDifference <= pointsRemaining) {
                character.charisma.value += 1
                character.charisma.updateAtribute()
                pointsRemaining = character.calculateStatusPointsRemaining()
            }
        }, onDecrease = {
            if (character.charisma.value > 8) {
                character.charisma.value -= 1
                character.charisma.updateAtribute()
                pointsRemaining = character.calculateStatusPointsRemaining()
            }
        })

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para finalizar a seleção de atributos e ir para a tela de atributos do personagem
        Button(onClick = {
            onNavigateToAttributes()
        }, enabled = pointsRemaining >= 0) {
            Text(text = "Finalizar Seleção de Atributos")
        }
    }
}


@Composable
fun AttributeRow(attribute: Atribute, onIncrease: () -> Unit, onDecrease: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = onDecrease) {
            Text("-")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "${attribute.name}: ${attribute.value}", fontSize = 18.sp)
        Spacer(modifier = Modifier.width(16.dp))
        Button(onClick = onIncrease) {
            Text("+")
        }
    }
}
