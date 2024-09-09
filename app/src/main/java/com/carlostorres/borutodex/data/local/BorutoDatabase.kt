package com.carlostorres.borutodex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.carlostorres.borutodex.data.local.dao.HeroDao
import com.carlostorres.borutodex.data.local.dao.HeroRemoteKeyDao
import com.carlostorres.borutodex.data.model.Hero
import com.carlostorres.borutodex.data.model.HeroRemoteKey

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase : RoomDatabase(){

    abstract fun heroDao() : HeroDao
    abstract fun heroRemoteKeyDao() : HeroRemoteKeyDao

}