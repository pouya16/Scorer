package com.example.scorer.database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    @NonNull var name:String,
    @NonNull var score: Int,
    @NonNull var b_var:Int,
    @NonNull var r_var:Int,
    @NonNull var s_var:Int,
    @NonNull var t_var:Int,
    @NonNull var z_var:Int,
    @NonNull var back_var:Int
)
