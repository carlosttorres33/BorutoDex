package com.carlostorres.borutodex.domain.repository

import androidx.paging.PagingData
import com.carlostorres.borutodex.data.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllHeroes() : Flow<PagingData<Hero>>
    fun searchHeroes(query: String) : Flow<PagingData<Hero>>
}