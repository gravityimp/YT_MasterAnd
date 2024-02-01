package com.example.yt_masterand.view

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.yt_masterand.MasterAndApplication

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            PlayerViewModel(masterAndApplication().container.playerRepository)
        }
        initializer {
            ScoreViewModel(masterAndApplication().container.scoreRepository)
        }
        initializer {
            ProfileWithScoreViewModel(masterAndApplication().container.playerWithScoreRepository)
        }
    }
}

fun CreationExtras.masterAndApplication(): MasterAndApplication = (
        this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MasterAndApplication)