package com.example.jetviewmodeldb.repo

import com.example.jetviewmodeldb.models.TaskModel
import com.example.jetviewmodeldb.sealed.TaskResult
import kotlinx.coroutines.flow.Flow

interface TaskOperationListener {

    val myTasks:Flow<List<String>>

    suspend fun getTasks() : Flow<List<String>>

    suspend fun insertTask(task:TaskModel)
}