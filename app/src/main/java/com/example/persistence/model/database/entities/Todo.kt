package com.example.persistence.model.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Todo(
    val name: String,
    val completed: Boolean = false,
    @PrimaryKey(autoGenerate = true)
    val taskId: Int = 0

)