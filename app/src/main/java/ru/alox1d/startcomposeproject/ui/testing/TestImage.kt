package ru.alox1d.startcomposeproject.ui.testing

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ru.alox1d.startcomposeproject.R

@Preview
@Composable
fun TestImage() {
    Image(
        modifier = Modifier.clip(CircleShape),
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "",
        contentScale = ContentScale.FillBounds
    )
}