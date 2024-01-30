package com.example.yt_masterand.repository

import com.example.yt_masterand.dao.PlayerWithScoreDao
import com.example.yt_masterand.model.PlayerWithScore
import com.example.yt_masterand.repository.base.PlayerWithScoreRepository
import kotlinx.coroutines.flow.Flow

class PlayerWithScoreRepositoryImpl(private val playerWithScoreDao: PlayerWithScoreDao) : PlayerWithScoreRepository {
    override fun getAllPlayersWithScores(): Flow<List<PlayerWithScore>> {
        return playerWithScoreDao.getPlayersWithScore()
    }
}