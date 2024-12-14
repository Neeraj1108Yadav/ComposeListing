package com.example.jetviewmodeldb.repo

import com.example.jetviewmodeldb.models.TaskModel
import kotlinx.coroutines.flow.Flow

interface TaskOperationListener {

    suspend fun getTasks() : Flow<List<String>>

    suspend fun insertTask(task:TaskModel)
}