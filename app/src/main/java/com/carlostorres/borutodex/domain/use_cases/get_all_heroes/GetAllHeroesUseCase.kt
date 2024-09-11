package com.carlostorres.borutodex.domain.use_cases.get_all_heroes

import com.carlostorres.borutodex.data.repository.Repository

class GetAllHeroesUseCase(
    private val repository: Repository
) {

    operator fun invoke() = repository.getAllHeroes()

}