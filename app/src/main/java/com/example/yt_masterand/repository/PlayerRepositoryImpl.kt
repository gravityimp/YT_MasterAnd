package com.example.yt_masterand.repository

import com.example.yt_masterand.dao.PlayerDao
import com.example.yt_masterand.model.Player
import com.example.yt_masterand.repository.base.PlayerRepository
import kotlinx.coroutines.flow.Flow

class PlayerRepositoryImpl(private val playerDao: PlayerDao) : PlayerRepository {
    override fun getAllPlayersStream(): Flow<List<Player>> {
        return playerDao.getAllPlayers()
    }

    override fun getPlayerById(playerId: Long): Flow<Player> {
        return playerDao.getPlayerById(playerId)
    }

    override fun getPlayersByEmail(email: String): Flow<Player> {
        return playerDao.getPlayerByEmail(email)
    }

    override suspend fun insertPlayer(player: Player) : Long {
        return playerDao.insertPlayer(player)
    }

    override suspend fun updatePlayer(player: Player) {
        playerDao.updatePlayer(player)
    }
}