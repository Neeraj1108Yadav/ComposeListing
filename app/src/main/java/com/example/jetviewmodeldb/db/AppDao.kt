package com.example.jetviewmodeldb.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.jetviewmodeldb.models.TaskModel
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

    @Insert
    suspend fun insertTask(task:TaskModel)

    @Query("SELECT * FROM TaskModel")
    fun getAllTask() : Flow<List<TaskModel>>
}