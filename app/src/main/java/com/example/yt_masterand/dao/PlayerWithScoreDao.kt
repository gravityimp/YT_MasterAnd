package com.example.yt_masterand.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.yt_masterand.model.PlayerWithScore
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerWithScoreDao {
    @Query("select players.playerId as playerId, scores.scoreId as scoreId, scores.score as score," +
            "players.name as name, players.email as email " +
            "from players, scores where players.playerId = scores.playerId")
    fun getPlayersWithScore(): Flow<List<PlayerWithScore>>
}