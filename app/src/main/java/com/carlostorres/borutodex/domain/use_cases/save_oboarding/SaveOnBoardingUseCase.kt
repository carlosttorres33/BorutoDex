package com.carlostorres.borutodex.domain.use_cases.save_oboarding

import com.carlostorres.borutodex.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(completed : Boolean) = repository.saveOnBoardingState(completed)

}