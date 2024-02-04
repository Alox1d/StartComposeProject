package ru.alox1d.startcomposeproject.ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alox1d.startcomposeproject.InstagramModel
import ru.alox1d.startcomposeproject.R
import ru.alox1d.startcomposeproject.ui.theme.StartComposeProjectTheme

@Composable
fun InstagramProfileCard(
    model: InstagramModel,
    onFollowButtonClickListener: (InstagramModel) -> Unit
) {
    // Delegation example
    var a: Int by remember {
        mutableStateOf(5)
    }
    val b: Int = a
    a = 10

    Card(
        modifier = Modifier
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        shape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 4.dp
        ),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.onBackground),
    ) {
        Log.d("RECOMPOSITION", "Card")

        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icons8_instagram),
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color = Color.White)
                        .padding(8.dp)
                        .size(60.dp),
                    contentDescription = null
                )
                UserStatistics(title = "Posts", "6,950")
                UserStatistics(title = "Followers", "436M")
                UserStatistics(title = "Following", "76")
            }
            Text(
                text = "Instagram ${model.id}",
                fontSize = 32.sp,
                fontFamily = FontFamily.Cursive,
            )
            Text(
                text = "#${model.title}",
                fontSize = 14.sp,
            )
            Text(
                text = "www.roskomnadzored.com/emotional_health",
                fontSize = 14.sp,
            )
            FollowButton(
                isFollowed = model.isFollowed,
                clickListener = {
                    onFollowButtonClickListener(model)
                }
            )
        }
    }
}

/**
 * Stateless Composable-function
 */
@Composable
private fun FollowButton(
    isFollowed: Boolean,
    clickListener: () -> Unit
) {
    Log.d("RECOMPOSITION", "FollowButton")

    Button(
        onClick = clickListener,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isFollowed) {
                MaterialTheme.colorScheme.primary.copy(
                    alpha = 0.5f
                )
            } else {
                MaterialTheme.colorScheme.primary
            }
        )
    ) {
        val text = if (isFollowed) "Unfollow" else "Follow"
        Text(text = text)
    }
}

@Composable
private fun UserStatistics(
    title: String,
    value: String
) {
    Column(
        modifier = Modifier.height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = value,
            fontSize = 24.sp,
            fontFamily = FontFamily.Cursive,
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview
@Composable
fun PreviewCardLight() {
    StartComposeProjectTheme(
        darkTheme = false
    ) {
        // InstagramProfileCard(viewModel)
    }
}

@Preview
@Composable
fun PreviewCardDark() {
    StartComposeProjectTheme(
        darkTheme = true
    ) {
        // InstagramProfileCard(viewModel)
    }
}