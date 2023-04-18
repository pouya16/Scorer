package com.example.scorer.database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.function.IntToLongFunction

@Entity
data class Chapters(
    @PrimaryKey val id:Int,
    @NonNull val game_id:Int,
    @NonNull val chap_number:Int,
    @NonNull val e_variable:Int,
    @NonNull val current_level:Int
)
