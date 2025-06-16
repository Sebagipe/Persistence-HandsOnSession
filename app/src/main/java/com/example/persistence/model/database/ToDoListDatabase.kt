package com.example.persistence.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.persistence.model.database.daos.ToDoListDao
import com.example.persistence.model.database.entities.Todo

//TODO 2: Implementere die Datenbank Klasse
// - Hier soll sichergestellt werden, dass die Datenbank genau einmal instantiiert wird (siehe Vorlesungsfolien)
@Database(version = 1, entities = [Todo::class])
abstract class ToDoListDatabase : RoomDatabase() {
    abstract val dao: ToDoListDao

    companion object {
        private const val DB_NAME = "todo_store"

        @Volatile
        private var INSTANCE: ToDoListDatabase? = null

        fun getInstance(context: Context): ToDoListDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    ToDoListDatabase::class.java,
                    DB_NAME
                ).build().also { INSTANCE = it }
            }
        }
    }
}