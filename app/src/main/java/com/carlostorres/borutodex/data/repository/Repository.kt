package com.carlostorres.borutodex.data.repository

import com.carlostorres.borutodex.domain.repository.DataStoreOperations
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: DataStoreOperations
) {

    suspend fun saveOnBoardingState(completed : Boolean) = dataStore.saveOnBoardingState(completed)

    fun readOnBoardingState() = dataStore.readOnBoardingState()

}