package com.rishi.basesetup.screen.exampleui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rishi.basesetup.data.models.ArticleData
import com.rishi.basesetup.domain.ExampleUseCase
import com.rishi.basesetup.navigation.AppArgs
import com.rishi.basesetup.util.Constant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val exampleUseCase: ExampleUseCase
) : ViewModel() {

    var uiState by mutableStateOf(ExampleScreenUiState())
        private set

    var uiSideEffect by mutableStateOf<ExampleScreenSideEffects>(ExampleScreenSideEffects.NoEffect)
        private set

    init {
        viewModelScope.launch {
            doSomeNetworkCall()
        }
    }

    private suspend fun doSomeNetworkCall() {
        exampleUseCase(
            country = Constant.COUNTRY,
            apiKey = Constant.API_KEY
        ).catch {
        }.collect {
            if (it.isSuccessful) {
                uiState = uiState.copy(isLoading = false, data = it.body()?.articles)
            }
        }
    }

    fun onEvent(event: ExampleScreenUIEvent) {
        when (event) {
            ExampleScreenUIEvent.OnBack -> {

            }

            is ExampleScreenUIEvent.ExampleDetailScreen -> {
                uiSideEffect = ExampleScreenSideEffects.OpenExampleDetailScreen(event.id)
            }
        }
    }

    fun resetUiSideEffect() {
        uiSideEffect = ExampleScreenSideEffects.NoEffect
    }

}

data class ExampleScreenUiState(
    val isLoading: Boolean = false,
    val data: List<ArticleData>? = null
)

sealed interface ExampleScreenUIEvent {
    data object OnBack : ExampleScreenUIEvent
    data class ExampleDetailScreen(val id: String) : ExampleScreenUIEvent
}

sealed interface ExampleScreenSideEffects {
    data object NoEffect : ExampleScreenSideEffects
    data object Back : ExampleScreenSideEffects
    data class OpenExampleDetailScreen(val id: String) : ExampleScreenSideEffects
}
