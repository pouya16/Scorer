package com.example.scorer.database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.function.IntToLongFunction

@Entity
data class Chapters(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @NonNull val game_id:Int,
    @NonNull val chap_number:Int,
    @NonNull var e_variable:Int,
    @NonNull var current_level:Int
)
