package ru.alox1d.startcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModelProvider
import ru.alox1d.startcomposeproject.ui.InstagramProfileCard
import ru.alox1d.startcomposeproject.ui.theme.StartComposeProjectTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContent {
            Test(viewModel = viewModel)
        }
    }
}

@Composable
fun Test(viewModel: MainViewModel) {
    StartComposeProjectTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            LazyColumn {
                item {
                    Text(text = "Title", color = Color.White)
                }
                items(10) {
                    InstagramProfileCard(viewModel)
                }
                item {
                    Image(painter = painterResource(id = R.drawable.icons8_instagram), contentDescription = null)
                }
                items(100) {
                    InstagramProfileCard(viewModel)
                }
            }
        }
    }
}