package com.carlostorres.borutodex.domain.use_cases

import com.carlostorres.borutodex.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.carlostorres.borutodex.domain.use_cases.save_oboarding.SaveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase
)
