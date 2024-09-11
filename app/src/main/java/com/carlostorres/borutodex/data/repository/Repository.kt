package com.carlostorres.borutodex.data.repository

import androidx.paging.PagingData
import com.carlostorres.borutodex.data.model.Hero
import com.carlostorres.borutodex.domain.repository.DataStoreOperations
import com.carlostorres.borutodex.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {

    suspend fun saveOnBoardingState(completed : Boolean) = dataStore.saveOnBoardingState(completed)

    fun readOnBoardingState() = dataStore.readOnBoardingState()

    fun getAllHeroes() : Flow<PagingData<Hero>> = remote.getAllHeroes()

}