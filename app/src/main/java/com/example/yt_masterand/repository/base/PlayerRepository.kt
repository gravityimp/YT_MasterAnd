package com.example.yt_masterand.repository.base

import com.example.yt_masterand.model.Player
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {
    fun getAllPlayersStream(): Flow<List<Player>>
    fun getPlayerById(playerId: Long): Flow<Player>
    fun getPlayersByEmail(email: String): Flow<Player>
    suspend fun insertPlayer(player: Player) : Long
    suspend fun updatePlayer(player: Player)
}