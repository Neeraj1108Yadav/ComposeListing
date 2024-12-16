package com.example.jetviewmodeldb.repo

import com.example.jetviewmodeldb.db.AppDao
import com.example.jetviewmodeldb.models.TaskModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskOperationsRepo @Inject constructor(private val appDao: AppDao) : TaskOperationListener {

    override val myTasks: Flow<List<String>>
        get() = appDao.getAllTask().map { items -> items.map { it.task } }

    override suspend fun getTasks(): Flow<List<String>> {
        return appDao.getAllTask().map { items -> items.map { it.task } }
    }

    override suspend fun insertTask(task: TaskModel) {
        appDao.insertTask(task)
    }
}