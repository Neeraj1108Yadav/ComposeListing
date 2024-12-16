package com.example.jetviewmodeldb.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetviewmodeldb.models.TaskModel

@Database(entities = [TaskModel::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getDao() : AppDao
}