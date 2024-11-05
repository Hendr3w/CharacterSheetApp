package com.example.charactersheetapp

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.example.charactersheetapp.*
import androidx.room.TypeConverters


@Database(entities = [Tav::class], version = 1)
@TypeConverters(AtributeTypeConverter::class, RaceConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tavDao(): TavDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "character_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
