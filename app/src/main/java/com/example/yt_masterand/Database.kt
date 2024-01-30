package com.example.yt_masterand;

import android.content.Context
import androidx.room.Database;
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.yt_masterand.dao.PlayerDao
import com.example.yt_masterand.dao.PlayerWithScoreDao
import com.example.yt_masterand.dao.ScoreDao
import com.example.yt_masterand.model.Player
import com.example.yt_masterand.model.Score
import kotlin.jvm.Volatile;

@Database(
        entities = [Player::class, Score::class],
        version = 1,
        exportSchema = false
)
abstract class MasterAndDatabase: RoomDatabase() {

        abstract fun getPlayerDao(): PlayerDao
        abstract fun getScoreDao(): ScoreDao
        abstract fun getPlayerWithScoreDao(): PlayerWithScoreDao
        companion object {
                @Volatile
                private var Instance: MasterAndDatabase? = null
                fun getDatabase(current: Context): MasterAndDatabase {
                        return Room.databaseBuilder(
                                current,
                                MasterAndDatabase::class.java,
                                "yt-masterand-database")
                                .build().also { Instance = it }
                }
        }
}