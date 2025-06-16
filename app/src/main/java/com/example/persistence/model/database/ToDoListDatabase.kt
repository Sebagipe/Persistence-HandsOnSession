package com.example.persistence.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.persistence.model.database.daos.ToDoListDao
import com.example.persistence.model.database.entities.Todo

//TODO 2: Implementere die Datenbank Klasse
// - Hier soll sichergestellt werden, dass die Datenbank genau einmal instantiiert wird (siehe Vorlesungsfolien)
abstract class ToDoListDatabase {}