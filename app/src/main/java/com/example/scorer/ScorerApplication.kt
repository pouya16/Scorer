package com.example.scorer

import android.app.Application
import com.example.scorer.database.AppDataBase

class ScorerApplication:Application() {
    val database : AppDataBase by lazy {AppDataBase.getDatabase(this)}
}
