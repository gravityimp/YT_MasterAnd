package com.example.yt_masterand.repository

import com.example.yt_masterand.dao.ScoreDao
import com.example.yt_masterand.model.Score
import com.example.yt_masterand.repository.base.ScoreRepository

class ScoreRepositoryImpl(private val scoreDao: ScoreDao) : ScoreRepository {
    override suspend fun insertScore(score: Score) {
        scoreDao.insertScore(score)
    }
}