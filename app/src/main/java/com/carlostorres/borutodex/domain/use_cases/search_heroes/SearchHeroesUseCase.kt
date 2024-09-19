package com.carlostorres.borutodex.domain.use_cases.search_heroes

import androidx.paging.PagingData
import com.carlostorres.borutodex.data.model.Hero
import com.carlostorres.borutodex.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCase(private val repository: Repository) {

    operator fun invoke(query : String): Flow<PagingData<Hero>> = repository.searchHeroes(query)

}