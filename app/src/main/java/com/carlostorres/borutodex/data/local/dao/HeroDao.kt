package com.carlostorres.borutodex.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.carlostorres.borutodex.data.model.Hero
import com.carlostorres.borutodex.util.Constants.HERO_DATABASE_TABLE

@Dao
interface HeroDao {

    @Query("SELECT * FROM $HERO_DATABASE_TABLE ORDER BY id ASC")
    fun getAllHeroes() : PagingSource<Int, Hero>

    @Query("SELECT * FROM $HERO_DATABASE_TABLE WHERE id=:heroID")
    fun getSelectedHero(heroID : Int) : Hero

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHeroes(heroes : List<Hero>)

    @Query("DELETE FROM $HERO_DATABASE_TABLE")
    suspend fun deleteAllHeroes()

}