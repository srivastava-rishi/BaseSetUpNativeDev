package com.rishi.basesetup.screen.exampledetail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.rishi.basesetup.R
import com.rishi.basesetup.navigation.actions.ExampleDetailScreenActions
import com.rishi.basesetup.ui.theme.paragraph


@Composable
fun ExampleDetailScreen(
    viewModel: ExampleDetailViewModel = hiltViewModel(),
    onAction: (exampleDetailScreenActions: ExampleDetailScreenActions) -> Unit
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ExampleDetailContent(
            data = viewModel.uiState.data,
            onEvent = onEvent
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExampleDetailContent(
    data: ExampleDetailItem?,
    onEvent: (ExampleDetailScreenUIEvent) -> Unit
) {
    Box(
        modifier = Modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data?.image.orEmpty())
                .error(R.drawable.pic)
                .placeholder(R.drawable.pic)
                .crossfade(true)
                .build(),
            contentDescription = "News Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .background(Color.Blue)
        )
        Column {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {
                    Row {
                        Spacer(modifier = Modifier.size(12.dp))
                        Icon(
                            modifier = Modifier
                                .size(16.dp)
                                .clickable {
                                    onEvent(ExampleDetailScreenUIEvent.OnBack)
                                },
                            painter = painterResource(id = R.drawable.ic_back),
                            tint = Color.White,
                            contentDescription = "Back Icon"
                        )
                    }
                }
            )

            Text(
                modifier = Modifier.padding(horizontal = 24.dp),
                text = data?.time.orEmpty(),
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFFFFFFFF),
                maxLines = 3
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                modifier = Modifier.padding(horizontal = 24.dp),
                text = data?.headline.orEmpty(),
                style = MaterialTheme.typography.paragraph,
                color = Color(0xFFFFFFFF),
                maxLines = 3
            )
            ExampleDetail(data)
        }
    }
}

@Composable
fun ExampleDetail(
    data: ExampleDetailItem?
) {
    Column(
        modifier = Modifier
            .padding(top = 24.dp, bottom = 60.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )
            .padding(start = 24.dp, end = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data?.userData?.photoUrl.orEmpty())
                    .error(R.drawable.pic)
                    .placeholder(R.drawable.pic)
                    .crossfade(true)
                    .build(),
                contentDescription = "Author Photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Blue)
            )
            Spacer(modifier = Modifier.size(8.dp))

            Column {
                Text(
                    text = data?.userData?.name.orEmpty(),
                    style = MaterialTheme.typography.paragraph,
                    color = Color(0xFF000000),
                )
                Spacer(modifier = Modifier.size(2.dp))
                Text(
                    text = data?.category.orEmpty(),
                    style = MaterialTheme.typography.paragraph,
                    color = Color.Red,
                )
            }
        }
        Spacer(modifier = Modifier.size(24.dp))
        Text(
            text = data?.description.orEmpty(),
            style = MaterialTheme.typography.paragraph,
            color = Color(0xFF000000),
        )
    }
}

private fun handelSideEffects(
    sideEffects: ExampleDetailScreenSideEffects,
    onAction: (actions: ExampleDetailScreenActions) -> Unit,
) {
    when (sideEffects) {
        ExampleDetailScreenSideEffects.Back -> {
            onAction(ExampleDetailScreenActions.OnBack)
        }

        else -> {}
    }
}



