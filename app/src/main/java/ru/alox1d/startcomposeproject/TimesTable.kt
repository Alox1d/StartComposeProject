package ru.alox1d.startcomposeproject

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun TimesTable() {
    Column(
        modifier = Modifier
            .padding(all = 16.dp)
    ) {
        for (colNumber in 1..9) {
            Row(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                for (rowNumber in 1..9) {
                    val value = colNumber * rowNumber
                    val color = if ((colNumber + rowNumber) % 2 == 0) Color.White else Color.Yellow
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(color = color)
                            .weight(0.5f)
                            .border(width = 1.dp, color = Color.DarkGray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "$value",
                        )
                    }
                }
            }
        }
    }
}