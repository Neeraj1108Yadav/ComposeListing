package com.example.jetviewmodeldb.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskModel(
    val task:String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}
