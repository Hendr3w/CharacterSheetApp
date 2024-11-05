package com.example.charactersheetapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateCharacterScreen(
    onCharacterCreated: (String, String) -> Unit,
    onNavigateToCharacterList: () -> Unit // Novo parâmetro para navegação
) {
    var characterName by remember { mutableStateOf("Tav") }
    var selectedRace by remember { mutableStateOf("Humano") }
    val races = listOf("Humano", "Elfo", "Anão", "Drow", "Meio-Elfo", "Halfling", "Meio-Orc", "Tiefling")

    val raceBonuses = mapOf(
        "Humano" to "Bônus: +1 em todos os atributos",
        "Elfo" to "Bônus: +2 em Destreza, +1 em Inteligência",
        "Anão" to "Bônus: +2 em Constituição, +1 em Sabedoria",
        "Drow" to "Bônus: +2 em Destreza, +1 em Inteligência",
        "Meio-Elfo" to "Bônus: +2 em Carisma",
        "Halfling" to "Bônus: +2 em Destreza, +1 em Carisma",
        "Meio-Orc" to "Bônus: +2 em Força, +1 em Constituição",
        "Tiefling" to "Bônus: +2 em Carisma, +1 em Inteligência"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = characterName,
            onValueChange = { characterName = it },
            label = { Text("Nome do Personagem") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Selecione a Raça:")
        LazyColumn {
            items(races) { race ->
                Button(
                    onClick = { selectedRace = race },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedRace == race) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                    )
                ) {
                    Text(text = race)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = raceBonuses[selectedRace] ?: "Selecione uma raça", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            onCharacterCreated(characterName, selectedRace)
        }) {
            Text(text = "Próximo")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para ir à tela de lista de personagens
        Button(onClick = onNavigateToCharacterList) {
            Text(text = "Lista de Personagens")
        }
    }
}
