package com.example.scorer.database

import androidx.room.*


@Dao
interface ChaptersDao {

    @Query("SELECT * FROM chapters")
    fun getAllChapters() : List<Chapters>

    @Query("SELECT * FROM chapters WHERE game_id = :game_id and chap_number = :chap_num")
    fun getChapterById(game_id:Int,chap_num:Int) : List<Chapters>

    @Query("SELECT * FROM chapters WHERE game_id = :game_id")
    fun getChapterByGame(game_id:Int) : List<Chapters>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(chapters : Chapters)

    @Update
    fun update(chapter : Chapters)

    @Delete
    fun delete(chapter : Chapters)

    @Query("DELETE FROM chapters WHERE game_id = :game_id")
    fun deleteByGame(game_id: Int)
}