package com.example.jetviewmodeldb.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DefaultButton(
    onSave:() -> Unit
){
    Button(
        onClick = onSave
    ) {
        Text(
            text = "Save"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultButtonPreview(){
    DefaultButton({})
}