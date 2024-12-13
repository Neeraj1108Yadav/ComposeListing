package com.example.jetviewmodeldb.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TaskViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<String>( "")
    val uiState: StateFlow<String> = _uiState

    fun updateMessage(name:String){
        _uiState.value = name
    }
}