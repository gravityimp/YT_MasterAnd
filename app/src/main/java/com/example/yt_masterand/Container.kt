package com.example.yt_masterand

import android.content.Context
import com.example.yt_masterand.repository.PlayerRepositoryImpl
import com.example.yt_masterand.repository.PlayerWithScoreRepositoryImpl
import com.example.yt_masterand.repository.ScoreRepositoryImpl
import com.example.yt_masterand.repository.base.PlayerRepository
import com.example.yt_masterand.repository.base.PlayerWithScoreRepository
import com.example.yt_masterand.repository.base.ScoreRepository

interface AppContainer {
    val playerRepository: PlayerRepository
    val scoreRepository: ScoreRepository
    val playerWithScoreRepository: PlayerWithScoreRepository
}
class AppDataContainer(private val context: Context) : AppContainer {
    override val playerRepository: PlayerRepository by lazy {
        PlayerRepositoryImpl(MasterAndDatabase.getDatabase(context).getPlayerDao())
    }

    override val scoreRepository: ScoreRepository by lazy {
        ScoreRepositoryImpl(MasterAndDatabase.getDatabase(context).getScoreDao())
    }

    override val playerWithScoreRepository: PlayerWithScoreRepository by lazy {
        PlayerWithScoreRepositoryImpl(MasterAndDatabase.getDatabase(context).getPlayerWithScoreDao())
    }
}