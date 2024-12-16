package com.example.jetviewmodeldb.sealed

sealed class TaskResult<out T> {
    data class Success<out T>(val data:T) : TaskResult<T>()
    data class Error(val message:String) : TaskResult<Nothing>()
    data object Loading : TaskResult<Nothing>()
}