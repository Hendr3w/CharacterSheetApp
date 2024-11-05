package com.example.charactersheetapp

import androidx.room.TypeConverter
import com.example.charactersheetapp.*

class AtributeTypeConverter {

    @TypeConverter
    fun fromAtribute(atribute: Atribute): String {
        return "${atribute.name},${atribute.value},${atribute.mod},${atribute.cost},${atribute.costUp}"
    }

    @TypeConverter
    fun toAtribute(data: String): Atribute {
        val values = data.split(",")
        return Atribute(
            name = values[0],
            value = values[1].toInt(),
            mod = values[2].toInt(),
            cost = values[3].toInt(),
            costUp = values[4].toInt()
        )
    }
}
