package com.rishi.basesetup.screen.exampledetail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.rishi.basesetup.navigation.AppArgs
import javax.inject.Inject

class ExampleDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var itemId: String = savedStateHandle[AppArgs.ARG_NEWS_ID]!!

    var uiState by mutableStateOf(ExampleDetailScreenUiState())
        private set

    var uiSideEffect by mutableStateOf<ExampleDetailScreenSideEffects>(
        ExampleDetailScreenSideEffects.NoEffect
    )
        private set


    init {
        fetch()
    }

    private fun fetch() {
        Log.d("lio9900", "fetch itemId:  $itemId")
        uiState = uiState.copy(
            data = ExampleDetailItem(
                id = "10",
                headline = "Discover the world's most breathtaking travel destinations and unique cultural experiences, from hidden gems to iconic landmarks.",
                description = "Travel enthusiasts are invited to explore some of the world's most breathtaking destinations and unique cultural experiences, ranging from hidden gems to iconic landmarks. Whether you are an adventurer seeking off-the-beaten-path locales or a traveler eager to visit renowned sites, there is something for everyone to discover. Among the top travel destinations are stunning natural wonders such as the Grand Canyon, the Great Barrier Reef, and the Northern Lights, each offering awe-inspiring beauty and unforgettable experiences. For those interested in rich cultural heritage, cities like Kyoto, Rome, and Marrakech provide a deep dive into history, architecture, and local traditions. Exploring these cities, visitors can enjoy ancient temples, historic ruins, and bustling markets, all while immersing themselves in the local way of life. Travelers looking for relaxation can find solace in serene beach destinations like the Maldives, Bora Bora, and the Seychelles, where crystal-clear waters and pristine sands offer the perfect backdrop for unwinding. Adventure seekers can embark on thrilling activities such as hiking in Patagonia, safaris in Kenya, or diving in Indonesia's coral reefs. Each destination not only offers unique sights and activities but also opportunities to connect with people from different cultures, fostering a deeper understanding and appreciation of the world. By planning a trip that aligns with personal interests and travel goals, individuals can create lasting memories and enrich their lives through the joy of exploration.",
                category = "Travel",
                time = "Fri, 14 July 2024",
                image = "https://images.unsplash.com/photo-1536431311719-398b6704d4cc?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NjJ8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D",
                userData = UserData(
                    name = "Emily Wilson",
                    photoUrl = "https://images.unsplash.com/photo-1485546246426-74dc88dec4d9?q=80&w=3538&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                ),
            )
        )
    }

    fun onEvent(event: ExampleDetailScreenUIEvent) {
        when (event) {
            ExampleDetailScreenUIEvent.OnBack -> {
                uiSideEffect = ExampleDetailScreenSideEffects.Back
            }
        }
    }

    fun resetUiSideEffect() {
        uiSideEffect = ExampleDetailScreenSideEffects.NoEffect
    }
}


data class ExampleDetailScreenUiState(
    val isLoading: Boolean = false,
    val data: ExampleDetailItem? = null
)

sealed interface ExampleDetailScreenUIEvent {
    data object OnBack : ExampleDetailScreenUIEvent
}

sealed interface ExampleDetailScreenSideEffects {
    data object NoEffect : ExampleDetailScreenSideEffects
    data object Back : ExampleDetailScreenSideEffects
}


data class ExampleDetailItem(
    val id: String,
    val headline: String,
    val description: String,
    val category: String,
    val time: String,
    val image: String,
    val userData: UserData
)

data class UserData(
    val name: String,
    val photoUrl: String,
)