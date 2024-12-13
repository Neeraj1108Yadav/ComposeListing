package com.example.jetviewmodeldb.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val task:String
)
