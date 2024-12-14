package com.example.jetviewmodeldb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetviewmodeldb.models.TaskModel
import com.example.jetviewmodeldb.repo.TaskOperationListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskOperationListener: TaskOperationListener
): ViewModel() {

    private val _uiState = MutableStateFlow<List<String>>( emptyList())
    val uiState: StateFlow<List<String>> = _uiState

    //fun updateMessage(name:String){ _uiState.value = name }

    init {
        observeTask()
    }

    fun observeTask(){
        viewModelScope.launch {
            taskOperationListener.getTasks()
                .collect{tasks ->
                    _uiState.value = tasks
                }
        }
    }

    fun insertTask(taskModel: TaskModel){
        viewModelScope.launch {
            taskOperationListener.insertTask(taskModel)
        }
    }
}