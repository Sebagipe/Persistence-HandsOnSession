package com.example.persistence.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.persistence.model.database.ToDoListDatabase
import com.example.persistence.model.database.entities.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(app: Application) : AndroidViewModel(app) {

    // Aufruf der Datenbankinstanz
    private val db = ToDoListDatabase.getInstance(app.applicationContext)
    private val dao = db.dao

    val incompleteEntries : LiveData<List<Todo>> = //TODO 4a ...
    val completedEntries : LiveData<List<Todo>> = //TODO 4b ...

    fun saveEntry(name: String) {
        val newEntry = ...//TODO 4c:
        viewModelScope.launch(Dispatchers.IO) {
            //TODO 4d: Rufe hier die Funktion auf, womit neu Todos in der Datenbank eingefügt werden können.
            // Hinweis zur Verständnis: viewModelScope.launch {} startet eine Coroutine. Alles was innerhalb der
            // geschweigte Klammern passiert, wird in einen anderen Thread ausgeführt. Dadurch wird kein
            // Datenbankzugriff auf der Main-Thread ausgeführt
        }
    }

    fun deleteEntry(entry: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            // TODO 4e: Rufe hier die Funktion auf, womit Todos von der Datenbank entfernt werden können
        }
    }

    fun toggleDone(entry: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            //TODO 4f: Rufe hier die Funktion auf, womit der Erledigungsstatus des Eintrags aktualisiert werden kann
            // Hinweis: Mit der Kotlin-Methode object.copy() kann man eine Kopie von einen Objekt aus eine
            // Data Class erstellen, mit Veränderungen zu Werte, die in einzelne Eigenschaften gespeichert sind.
            // Beispiel: entry.copy(name = "Clean Dishes")
        }
    }

}