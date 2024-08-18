package com.rishi.basesetup.screen.exampleui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.rishi.basesetup.R
import com.rishi.basesetup.data.models.ArticleData
import com.rishi.basesetup.navigation.actions.ExampleScreenActions
import com.rishi.basesetup.ui.theme.paragraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExampleScreen(
    viewModel: ExampleViewModel = hiltViewModel(),
    onAction: (exampleScreenActions: ExampleScreenActions) -> Unit
) {
    val onEvent = remember(key1 = viewModel) {
        return@remember viewModel::onEvent
    }

    val systemUiController = rememberSystemUiController()
    val context = LocalContext.current

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Black
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier,
                title = {
                    Row {
                        Spacer(modifier = Modifier.size(24.dp))
                        Image(
                            painter = painterResource(id = R.drawable.logo2x),
                            contentDescription = ""
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        ExampleScreenContent(
            modifier = Modifier.padding(innerPadding),
            onEvent = onEvent,
            uiState = viewModel.uiState
        )
    }

    LaunchedEffect(key1 = viewModel.uiSideEffect) {
        handelSideEffects(
            sideEffects = viewModel.uiSideEffect,
            onAction = onAction
        )
        viewModel.resetUiSideEffect()
    }
}


@Composable
private fun ExampleScreenContent(
    modifier: Modifier,
    uiState: ExampleScreenUiState,
    onEvent: (ExampleScreenUIEvent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
    ) {
        val exampleList = uiState.data.orEmpty()
        LazyColumn(
            content = {
                itemsIndexed(
                    items = exampleList
                ) { index, it ->
                    val lastItem = index == exampleList.size
                    if (exampleList.isNotEmpty()) {
                        ExampleItem(it, lastItem) {
                            onEvent(ExampleScreenUIEvent.ExampleDetailScreen(it))
                        }
                    }
                }
            })
    }
}

@Composable
fun ExampleItem(
    item: ArticleData,
    lastItem: Boolean,
    onClick: (newsId: String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(
                top = if (!lastItem) 8.dp else 0.dp
            )
    ) {
        Box(
            modifier = Modifier
                .background(color = Color(0xFFE8E8F7))
                .height(2.dp)
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 8.dp)
        )
        // Using Coil library to load an image from a URL into our composable
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = item.url)
                .error(R.drawable.pic)
                .placeholder(R.drawable.pic)
                .crossfade(true)
                .build(),
            contentDescription = "bankIcon",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Blue)
        )

        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = item.title.orEmpty(),
            style = MaterialTheme.typography.paragraph,
            color = Color(0xFF181818),
            maxLines = 2
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = item.description.orEmpty(),
            style = MaterialTheme.typography.labelSmall,
            color = Color(0xFF181818),
            maxLines = 3
        )
        Spacer(modifier = Modifier.size(16.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(6.dp),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF94C77D)
            ),
            content = {
                Text(
                    text = "Read more",
                    color = Color(0xFFFFFFFF),
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1
                )
            },
            onClick = {
                onClick.invoke("99")
            },
        )
    }
}

private fun handelSideEffects(
    sideEffects: ExampleScreenSideEffects,
    onAction: (actions: ExampleScreenActions) -> Unit,
) {
    when (sideEffects) {
        ExampleScreenSideEffects.Back -> {
            onAction(ExampleScreenActions.OnBack)
        }

        is ExampleScreenSideEffects.OpenExampleDetailScreen -> {
            onAction(ExampleScreenActions.OpenExampleDetailScreen(sideEffects.id))
        }

        else -> {}
    }
}

@Preview
@Composable
fun ExamplePreview() {
    val uiState = ExampleScreenUiState()
    ExampleScreenContent(modifier = Modifier, uiState = uiState, {})
}