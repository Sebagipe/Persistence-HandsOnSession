package com.example.persistence.model.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.persistence.model.database.entities.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoListDao {
    //TODO 3a:
    @Delete
    fun deleteTodo(entry : Todo)
    //TODO 3b:
    @Insert
    fun insertTodo(entry : Todo)
    //TODO 3c:
    @Update
    fun updateTodo(entry : Todo)

    //TODO 3d:
    @Query("Select * from Todo where completed = 0")
    fun getPendingTodos () : LiveData<List<Todo>>

    //TODO 3e:
    @Query("Select * from Todo where completed = 1")
    fun getCompletedTodos () : LiveData<List<Todo>>



}