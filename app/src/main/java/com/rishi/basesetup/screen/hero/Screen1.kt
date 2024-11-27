package com.rishi.basesetup.screen.hero

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Screen1() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier.fillMaxWidth()
                .background(Color.Black)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TopSection()
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            BottomSection()
        }
    }
}


@Composable
fun TopSection(){
    Column(
        modifier = Modifier
            .width(250.dp)
            .height(250.dp)
            .background(Color.Red)
    ) {

    }
}


@Composable
fun BottomSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(vertical = 24.dp)
            .background(Color.Magenta)
    ) {

    }
}


@MultiDevicePreview
@Composable
fun ShowUi(){
    Screen1()
}


