package ru.alox1d.startcomposeproject.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun UserInfoPreview() {
    UserInfo(name = "John", age = 25)
}

@Composable
fun UserInfo(name: String, age: Int) {
    Column {
        repeat(10) {
            Text(
                text = "Hello $name! with $age age",
            )
        }
    }
}