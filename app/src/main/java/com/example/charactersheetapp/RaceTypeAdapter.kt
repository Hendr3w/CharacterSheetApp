package com.example.charactersheetapp

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import races.Race


class RaceTypeAdapter : TypeAdapter<Race>() {
    override fun write(out: JsonWriter?, value: Race?) {
        // Implementar a lógica de serialização aqui
    }

    override fun read(input: JsonReader?): Race {
        // Implementar a lógica de deserialização aqui
        // Por exemplo, baseado em um campo "type" do JSON, você pode retornar uma instância concreta
    }
}
