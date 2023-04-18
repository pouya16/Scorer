package com.example.scorer.database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @PrimaryKey val id:Int,
    @NonNull val name:String,
    @NonNull val score: Int,
    @NonNull val b_var:Int,
    @NonNull val r_var:Int,
    @NonNull val s_var:Int,
    @NonNull val t_var:Int,
    @NonNull val back_var:Int
)
