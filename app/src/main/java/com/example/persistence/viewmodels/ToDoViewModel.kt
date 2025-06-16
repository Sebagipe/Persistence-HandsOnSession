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

    val incompleteEntries = dao.getPendingTodos()
    val completedEntries = dao.getCompletedTodos()

    fun saveEntry(name: String) {
        val newEntry = Todo(name = name)
        viewModelScope.launch(Dispatchers.IO) {
            dao.insertTodo(newEntry)
        }
    }

    fun deleteEntry(entry: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteTodo(entry)
        }
    }

    fun toggleDone(entry: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.updateTodo(entry.copy(completed = !entry.completed))
        }
    }

}