package com.carlostorres.borutodex.domain.use_cases.get_selected_hero

import com.carlostorres.borutodex.data.model.Hero
import com.carlostorres.borutodex.data.repository.Repository

class GetSelectedHeroUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(heroID: Int): Hero = repository.getSelectedHero(heroID)
}