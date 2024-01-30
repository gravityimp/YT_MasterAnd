package com.example.yt_masterand.dao

import androidx.room.*
import com.example.yt_masterand.model.Player
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Query("select * from players")
    fun getAllPlayers(): Flow<List<Player>>

    @Query("select * from players where playerId = :playerId")
    fun getPlayerById(playerId: Long): Flow<Player>

    @Query("select * from players where email = :email")
    fun getPlayerByEmail(email: String): Flow<Player>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPlayer(profile: Player) : Long

    @Update
    suspend fun updatePlayer(profile: Player)
}