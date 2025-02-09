package com.rishi.test

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rishi.basesetup.ui.theme.blue
import com.rishi.basesetup.ui.theme.white
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun CounterApp() {
    val scope = rememberCoroutineScope()
    var startCounter by remember {
        mutableStateOf(false)
    }
    var text by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(startCounter) {
        if (startCounter) {
            while (startCounter) {
                delay(1000)
                text = (text + 1)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Counter App",
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.size(12.dp))
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(blue, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = text.toString(),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 55.sp
                ),
                color = Color.Red
            )
        }
        Spacer(modifier = Modifier.size(12.dp))

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            onClick = {
                startCounter = true
            }) {
            Text(
                text = "Start",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            onClick = {
                startCounter = false
                text = 0
            }) {
            Text(
                text = "Stop",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewForCounterApp() {
    CounterApp()
}