package com.carlostorres.borutodex.presentation.home

import androidx.lifecycle.ViewModel
import com.carlostorres.borutodex.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    val getAllHeroes = useCases.getAllHeroesUseCase()

}