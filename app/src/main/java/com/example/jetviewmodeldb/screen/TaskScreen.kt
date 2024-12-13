package com.example.jetviewmodeldb.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.jetviewmodeldb.components.DefaultButton
import com.example.jetviewmodeldb.components.InputTaskField
import com.example.jetviewmodeldb.viewmodel.TaskViewModel


@Composable
fun TaskScreen(
    modifier: Modifier = Modifier,
    viewModel:TaskViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
){
    val task = remember { mutableStateOf<String>("") }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            InputTaskField(text = task)
            DefaultButton {
                viewModel.updateMessage(task.value)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Data $uiState")
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun TaskScreenPreview(){
    TaskScreen()
}