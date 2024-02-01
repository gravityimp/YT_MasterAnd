package com.example.yt_masterand.screen

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.yt_masterand.R
import com.example.yt_masterand.nav.Screen
import com.example.yt_masterand.view.PlayerViewModel
import com.example.yt_masterand.view.AppViewModelProvider

@Composable
fun ProfileImage(profileImageUri: Uri?,) {
    if(profileImageUri != null) {
        AsyncImage(
            model = profileImageUri,
            contentDescription = "Profile image",
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    } else {
        Image(
            painter = painterResource(
                id = R.drawable.qmark
            ),
            contentDescription = "Profile photo",
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Email(email: String) {
    Text(text = "Email: $email")
}

@Composable
fun Username(username: String) {
    Text(
        modifier = Modifier
            .padding(bottom = 15.dp),
        fontSize = 36.sp,
        text = username
    )
}

@Composable
fun ProfileScreenInitial(
    navController: NavController,
    playerId: Long,
    colors: Int,
    playerViewModel: PlayerViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    LaunchedEffect(key1 = playerViewModel.playerId) {
        playerViewModel.getPlayerById(playerId = playerId)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ProfileImage(profileImageUri = null)
        Username(username = playerViewModel.name)
        Email(email = playerViewModel.email)
        Button(onClick = {
            navController.navigate(route = Screen.Game.route + "/${playerId}/${colors}")
        }) { Text(text = "Return to game") }
    }

}



