package com.rishi.basesetup.screen.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rishi.basesetup.navigation.actions.TestScreenActions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestScreen(
    onAction: (homeScreenActions: TestScreenActions) -> Unit
) {
    TestScreenContent()
}

@Composable
private fun TestScreenContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
    ) {

    }
}

@Preview
@Composable
fun TestScreenPreview() {
    TestScreenContent(modifier = Modifier)
}
