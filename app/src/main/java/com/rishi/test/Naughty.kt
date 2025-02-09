package com.rishi.test

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rishi.basesetup.screen.exampledetail.ExampleDetailScreenUIEvent
import com.rishi.basesetup.screen.exampledetail.ExampleDetailViewModel
import com.rishi.basesetup.ui.theme.black_60
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch




@Composable
fun NaughtyScreen(
    viewModel: ExampleDetailViewModel = hiltViewModel(),
) {

    val scope = rememberCoroutineScope()

    LaunchedEffect(viewModel.uiState.doSomething) {
        launch {

        }
        launch {

        }
    }


    Column {
        TextField(
            value = "",
            onValueChange = {

            }
        )
    }

    NaughtyContent(
        poty = {
        }
    )

}


@Composable
fun NaughtyContent(
    poty: (ExampleDetailScreenUIEvent) -> Unit
) {
    TextField(
        value = "",
        onValueChange = {
        }
    )
}


@Preview(showBackground = true)
@Composable
fun NaughtyPreview() {14
    NaughtyContent({})
}