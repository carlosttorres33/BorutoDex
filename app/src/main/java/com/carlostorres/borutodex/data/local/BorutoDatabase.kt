package com.carlostorres.borutodex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.carlostorres.borutodex.data.model.Hero

@Database(entities = [Hero::class], version = 1)
abstract class BorutoDatabase : RoomDatabase(){

    abstract fun heroDao() : HeroDao

}