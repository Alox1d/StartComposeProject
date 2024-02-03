package ru.alox1d.startcomposeproject.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ColumnScope.TestText(count: Int, text: String) {
    repeat(count) {
        Text(
            modifier = Modifier.weight(1f),
            text = text
        )
    }
}

@Preview
@Composable
private fun PreviewText() {
    Column(Modifier.fillMaxSize()) {
        TestText(text = "Text", count = 5)
    }
}