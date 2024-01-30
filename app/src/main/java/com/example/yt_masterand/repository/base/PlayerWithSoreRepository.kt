package com.example.yt_masterand.repository.base

import com.example.yt_masterand.model.PlayerWithScore
import kotlinx.coroutines.flow.Flow

interface PlayerWithScoreRepository {

    fun getAllPlayersWithScores(): Flow<List<PlayerWithScore>>
}