package com.example.yt_masterand.repository.base

import com.example.yt_masterand.model.Score


interface ScoreRepository {

    suspend fun insertScore(score: Score)

}