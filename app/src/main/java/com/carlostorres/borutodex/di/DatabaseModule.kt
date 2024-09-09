package com.carlostorres.borutodex.di

import android.content.Context
import androidx.room.Room
import com.carlostorres.borutodex.data.local.BorutoDatabase
import com.carlostorres.borutodex.util.Constants.BORUTO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideBorutoDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context = context,
        klass = BorutoDatabase::class.java,
        name = BORUTO_DATABASE
    ).fallbackToDestructiveMigration()
        .build()

}