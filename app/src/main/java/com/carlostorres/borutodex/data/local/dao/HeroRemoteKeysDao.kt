package com.carlostorres.borutodex.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.carlostorres.borutodex.data.model.HeroRemoteKeys
import com.carlostorres.borutodex.util.Constants.HERO_REMOTE_KEYS_DATABASE_TABLE

@Dao
interface HeroRemoteKeysDao {

    @Query("SELECT * FROM $HERO_REMOTE_KEYS_DATABASE_TABLE WHERE id =:id")
    suspend fun getRemoteKeys(id: Int): HeroRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(heroRemoteKeys: List<HeroRemoteKeys>)

    @Query("DELETE FROM $HERO_REMOTE_KEYS_DATABASE_TABLE")
    suspend fun deleteAllRemoteKeys()

}