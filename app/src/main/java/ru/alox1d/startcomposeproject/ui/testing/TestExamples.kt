package ru.alox1d.startcomposeproject.ui.testing

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
private fun Test() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Example3()
    }
}

@Composable
private fun Example1() {
    OutlinedButton(onClick = {}) {
        Text(text = "Hello World")
    }
}

@Composable
private fun Example2() {
    TextField(
        value = "Value",
        onValueChange = {},
        label = { Text(text = "Label") }
    )
}

@Composable
private fun Example3() {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Yes"
            )
        },
        title = {
            Text(
                text = "Are you sure?"
            )
        },
        text = {
            Text(text = "Do you want to delete this file?")
        },
        dismissButton = {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "No"
            )
        }
    )
}