package com.example.scorer.database

import androidx.room.*


@Dao
interface GameDao {

    @Query("SELECT * FROM game")
    fun getAllGames() : List<Game>

    @Query("SELECT * FROM game WHERE id = :id")
    fun getGameById(id:Int) : List<Game>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(game: Game)

    @Update
    fun update(game: Game)

    @Delete
    fun delete(game: Game)

}