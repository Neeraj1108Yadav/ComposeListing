package com.example.jetviewmodeldb.components

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun InputTaskField(
    text:MutableState<String>
){
    TextField(
        value = text.value,
        onValueChange = {text.value = it}
    )
}