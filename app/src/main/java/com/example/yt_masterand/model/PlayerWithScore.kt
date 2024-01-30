package com.example.yt_masterand.model

data class PlayerWithScore(
    val scoreId: Long,
    val playerId: Long,
    val score: Int,
    val name: String,
    val email: String,
)