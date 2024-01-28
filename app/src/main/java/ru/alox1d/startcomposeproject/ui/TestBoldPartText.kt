package ru.alox1d.startcomposeproject.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun TestBoldPartText() {
    Text(
        buildAnnotatedString {
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Hello")
            }
            withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                append(" ")
            }
            withStyle(SpanStyle(fontSize = 30.sp, textDecoration = TextDecoration.LineThrough)) {
                append("World")
                append("!")
            }
        }
    )
}