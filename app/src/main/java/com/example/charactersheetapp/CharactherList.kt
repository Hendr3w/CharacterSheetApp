package com.example.charactersheetapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun CharacterListScreen(characterList: List<Tav>, onCharacterSelected: (Tav) -> Unit) {
    Column {
        for (character in characterList) {
            Text(
                text = character.name,
                modifier = Modifier
                    .clickable { onCharacterSelected(character) } // Ação ao clicar no personagem
                    .padding(8.dp)
            )
        }
    }
}
