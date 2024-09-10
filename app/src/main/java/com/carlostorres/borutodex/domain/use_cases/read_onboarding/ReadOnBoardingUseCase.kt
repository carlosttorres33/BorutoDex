package com.carlostorres.borutodex.domain.use_cases.read_onboarding

import com.carlostorres.borutodex.data.repository.Repository

class ReadOnBoardingUseCase(
    private val repository: Repository
) {

    operator fun invoke() = repository.readOnBoardingState()

}