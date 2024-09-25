package com.carlostorres.borutodex.presentation.details

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.carlostorres.borutodex.data.model.Hero
import com.carlostorres.borutodex.domain.use_cases.UseCases
import com.carlostorres.borutodex.util.Constants.DETAILS_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(DetailsState())
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {

            val heroID = savedStateHandle.get<Int>(DETAILS_ARGUMENT_KEY)
            heroID?.let {
                val res = useCases.getSelectedHeroUseCase(heroID = heroID)
                state = state.copy(selectedHero = res)
            }

        }
    }

}

data class DetailsState(
    val selectedHero : Hero? = null
)