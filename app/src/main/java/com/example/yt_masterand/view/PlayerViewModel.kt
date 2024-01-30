package com.example.yt_masterand.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yt_masterand.model.Player
import com.example.yt_masterand.repository.base.PlayerRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class PlayerViewModel(private val playerRepository: PlayerRepository): ViewModel() {
    var playerId by mutableStateOf(0L)
        private set
    var name by mutableStateOf("")
    var email by mutableStateOf("")
        private set

    fun updatePlayerId(newPlayerId: Long) {
        playerId = newPlayerId
    }

    fun updateName(newName: String) {
        name = newName
    }

    fun updateEmail(newEmail: String) {
        email = newEmail
    }

    suspend fun savePlayer() {
        try {
            val player = playerRepository.getPlayersByEmail(email).first()
            val profileToUpdate = Player(player.playerId, player.name, player.email)
            playerRepository.updatePlayer(profileToUpdate)
            playerId = player.playerId
        } catch (npe: NullPointerException) {
            val player = Player(name = name, email = email)
            playerId = playerRepository.insertPlayer(player)
        }
    }

    fun getAllPlayers(): List<Player> {
        var all : List<Player> = emptyList()
        viewModelScope.launch {
            val allPlayersStream = playerRepository.getAllPlayersStream()
            all = allPlayersStream.first()
        }
        return all
    }

    suspend fun getPlayerById(playerId: Long) {
        val player = playerRepository.getPlayerById(playerId).first()
        this.playerId = player.playerId
        this.name = player.name
        this.email = player.email
    }

}