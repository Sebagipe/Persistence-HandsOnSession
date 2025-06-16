package com.example.persistence.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.persistence.model.database.ToDoListDatabase
import com.example.persistence.model.database.entities.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(app: Application) : AndroidViewModel(app) {

    private val db = ToDoListDatabase.getInstance(app.applicationContext)
    private val dao = db.dao

    val incompleteEntries = dao.getPendingTodos() //TODO 4a
    val completedEntries = dao.getCompletedTodos() //TODO 4b

    fun saveEntry(name: String) {
        //TODO 4c:
        val newEntry = Todo(name = name)
        viewModelScope.launch(Dispatchers.IO) {
            dao.insertTodo(newEntry)
        }
    }

    fun deleteEntry(entry: Todo) {
        //TODO 4d
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteTodo(entry)
        }
    }

    fun toggleDone(entry: Todo) {
        //TODO 4e
        viewModelScope.launch(Dispatchers.IO) {
            dao.updateTodo(entry.copy(completed = !entry.completed))
        }
    }

}