package com.example.ytmaster.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.yt_masterand.model.PlayerWithScore
import com.example.yt_masterand.nav.Screen
import com.example.yt_masterand.view.ProfileWithScoreViewModel
import com.example.yt_masterand.view.AppViewModelProvider

@Composable
fun ResultScreen(
    navController: NavHostController,
    playerId: Long,
    recentScore: Int,
    colors: Int,
    profileWithScoreViewModel: ProfileWithScoreViewModel = viewModel( factory = AppViewModelProvider.Factory)
) {

    val scores by profileWithScoreViewModel.profileWithScore.collectAsState()

    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        TileText(text = "Results")
        RecentScore(score = recentScore)
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(items = scores.sortedBy { it.score }) { score ->
                ListItem(playerWithScore = score)
            }
        }
        GameButtons(navController = navController, playerId = playerId, colors = colors)
    }

}

@Composable
fun TileText(text: String) {
    Text(
        fontSize = 50.sp,
        modifier = Modifier
            .padding(bottom = 30.dp),
        text = text)
}

@Preview(showBackground = true)
@Composable
fun RecentScorePreview() {
    RecentScore(score = 4)
}

@Composable
fun RecentScore(score: Int) {
    Text(
        fontSize = 40.sp,
        modifier = Modifier
            .padding(bottom = 15.dp),
        text = "Recent score: $score")
}

@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
    val profileWithScore = PlayerWithScore(playerId = 0L, scoreId = 0L, score = 1, name = "Test", email = "test@test.com")
    ListItem(playerWithScore = profileWithScore)
}

@Composable
fun ListItem(playerWithScore: PlayerWithScore) {
    CompositionLocalProvider (
        LocalTextStyle provides TextStyle(fontSize = 30.sp)
    ) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .drawBehind {
                val strokeWidth = density * 2
                val y = size.height - strokeWidth / 2

                drawLine(
                    Color.Black,
                    Offset(0f, y),
                    Offset(size.width, y),
                    strokeWidth
                )
            },
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = playerWithScore.name)
            Text(text = playerWithScore.score.toString())
        }
    }
}

@Composable
fun GameButtons(navController: NavHostController = rememberNavController(), playerId: Long, colors: Int) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = { navController.navigate(route = Screen.Login.route) }) {
            Text(text = "Logout")
        }
        Button(onClick = { navController.navigate(route = Screen.Game.route + "/$playerId/$colors") }) {
            Text(text = "Restart game")
        }
    }
}