package com.example.jetviewmodeldb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetviewmodeldb.models.TaskModel
import com.example.jetviewmodeldb.repo.TaskOperationListener
import com.example.jetviewmodeldb.sealed.TaskResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskOperationListener: TaskOperationListener
): ViewModel() {

    val uiState: StateFlow<TaskResult<List<String>>> = taskOperationListener.myTasks
        .map{data->
            TaskResult.Success(data)
        }
        .catch {e->
            TaskResult.Error("Error : ${e.message}")
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), TaskResult.Loading)

    //fun updateMessage(name:String){ _uiState.value = name }

    private val _uiTask = MutableStateFlow<List<String>>( emptyList())
    val uiTask: StateFlow<List<String>> = _uiTask

    /*init {
        observeTask()
    }*/

    private fun observeTask(){
        viewModelScope.launch {
            taskOperationListener.getTasks()
                .collect{tasks ->
                    _uiTask.value = tasks
                }
        }
    }

    fun insertTask(taskModel: TaskModel){
        viewModelScope.launch {
            taskOperationListener.insertTask(taskModel)
        }
    }
}