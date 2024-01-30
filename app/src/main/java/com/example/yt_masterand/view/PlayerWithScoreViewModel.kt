package com.example.yt_masterand.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yt_masterand.repository.base.PlayerWithScoreRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class ProfileWithScoreViewModel(private val profileWithScoreRepository: PlayerWithScoreRepository) : ViewModel() {
    val profileWithScore = profileWithScoreRepository
        .getAllPlayersWithScores()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )
}