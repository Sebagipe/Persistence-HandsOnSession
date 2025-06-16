package com.example.persistence.model.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.persistence.model.database.entities.Todo
import kotlinx.coroutines.flow.Flow

//TODO 3a:
interface ToDoListDao {
    //TODO 3b:
    fun deleteTodo(entry : Todo)
    //TODO 3c:
    fun insertTodo(entry : Todo)
    //TODO 3d:
    fun updateTodo(entry : Todo)

    //TODO 3e: Funktion, die alle Einträge zurückgibt, die noch nicht erledigt wurden
    fun getPendingTodos () : LiveData<List<Todo>>

    //TODO 3f:  Funktion, die alle Einträge zurückgibt, die bereits erledigt wurden
    fun getCompletedTodos () : LiveData<List<Todo>>



}