package com.example.charactersheetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import races.Human
import races.Race

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var character by remember { mutableStateOf<Tav?>(null) }
    var currentScreen by remember { mutableStateOf("CreateCharacter") }

    MaterialTheme {
        Surface {
            when (currentScreen) {
                "CreateCharacter" -> {
                    CreateCharacterScreen { name, raceName ->
                        val selectedRace: Race = when (raceName) {
                            "Humano" -> Human()
                            else -> Human()
                        }
                        character = Tav(
                            name = name,
                            raceName = raceName,
                            race = selectedRace,
                            strength = Atribute("Força"),
                            dexterity = Atribute("Destreza"),
                            constituition = Atribute("Constituição"),
                            wisdom = Atribute("Sabedoria"),
                            intelligence = Atribute("Inteligência"),
                            charisma = Atribute("Carisma")
                        )
                        currentScreen = "AttributeSelection"
                    }
                }

                "AttributeSelection" -> {
                    character?.let {
                        AttributeSelectionScreen(it) {
                            currentScreen = "CharacterAttributes" // Navega para a tela de atributos
                        }
                    }
                }

                "CharacterAttributes" -> {
                    character?.let {
                        CharacterAttributesScreen(it) // Sua tela que mostra os atributos do personagem
                    }
                }
            }
        }
    }
}
