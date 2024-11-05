package com.example.charactersheetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.room.*
import androidx.compose.ui.tooling.preview.Preview
import races.Human
import races.Race
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var database: AppDatabase
    private lateinit var characterDao: TavDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializando o banco de dados
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "character_database"
        ).build()

        characterDao = database.tavDao()

        setContent {
            MyApp()
        }
    }

    @Composable
    fun MyApp() {
        var character by remember { mutableStateOf<Tav?>(null) }
        var currentScreen by remember { mutableStateOf("CreateCharacter") }
        var characterList by remember { mutableStateOf(listOf<Tav>()) }
        val coroutineScope = rememberCoroutineScope()

        LaunchedEffect(Unit) {
            characterList = characterDao.getAllTavs()
        }

        MaterialTheme {
            Surface {
                when (currentScreen) {
                    "CreateCharacter" -> {
                        CreateCharacterScreen(
                            onCharacterCreated = { name, raceName ->
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

                                currentScreen = "AttributeSelection" // Navega para a tela de seleção de atributos
                            },
                            onNavigateToCharacterList = {
                                currentScreen = "CharacterList" // Navega para a tela de lista de personagens
                            }
                        )
                    }

                    "AttributeSelection" -> {
                        character?.let {
                            AttributeSelectionScreen(it) {
                                currentScreen = "CharacterAttributes" // Navega para a tela de atributos
                            }
                        }
                    }

                    "CharacterList" -> {
                        CharacterListScreen(characterList = characterList, onCharacterSelected = { selectedCharacter ->
                            // Lógica ao selecionar um personagem
                            println("Personagem selecionado: ${selectedCharacter.name}")
                            // Aqui você pode navegar para uma tela de detalhes ou editar o personagem
                        })
                    }

                    "CharacterAttributes" -> {
                        character?.let {
                            CharacterAttributesScreen(it) { savedCharacter ->
                                // Salvar o personagem no banco de dados
                                coroutineScope.launch(Dispatchers.IO) {
                                    characterDao.insert(savedCharacter) // Insere o personagem no banco de dados
                                    // Atualiza a lista de personagens após a inserção
                                    characterList = characterDao.getAllTavs()
                                }
                                currentScreen = "CharacterList" // Navega para a tela de lista de personagens
                            }
                        }
                    }
                }
            }
        }
    }
}
