package com.example.persistence.model.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.persistence.model.database.entities.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoListDao {
    @Delete
    fun deleteTodo(entry : Todo)

    @Insert
    fun insertTodo(entry : Todo)

    @Update
    fun updateTodo(entry : Todo)

    @Query("Select * from Todo where completed = 0")
    fun getPendingTodos () : Flow<List<Todo>>

    @Query("Select * from Todo where completed = 1")
    fun getCompletedTodos () : Flow<List<Todo>>



}