package com.rishi.basesetup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.rishi.basesetup.navigation.AppNavGraph
import com.rishi.basesetup.navigation.AppNavGraph2
import com.rishi.basesetup.navigation.AppNavigationActions
import com.rishi.basesetup.ui.theme.BaseSetupTheme
import com.rishi.basesetup.ui.theme.black_60
import com.rishi.basesetup.ui.theme.redDark
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            BaseSetupTheme { // A surface container using the 'background' color from the theme
                Hi()
            }
        }
    }

    private fun hen() {
        Thread.sleep(12 * 1000)
    }
}

// medicine , cockroach killer

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun DemoApp(
    onNavigationEnd: () -> Unit
) {
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberNavController()
    val navActions: AppNavigationActions = remember(navController) {
        AppNavigationActions(navController, onNavigationEnd)
    }
    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        modifier = Modifier.fillMaxSize(),
        sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
    ) {
        AppNavGraph(
            navController = navController,
            navActions = navActions
        )
    }
}


@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun NavGraph(
    onNavigationEnd: () -> Unit
) {
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberNavController()
    val navActions: AppNavigationActions = remember(navController) {
        AppNavigationActions(navController, onNavigationEnd)
    }
    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        modifier = Modifier.fillMaxSize(),
        sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
    ) {
        AppNavGraph2(
            navController = navController,
            navActions = navActions
        )
    }
}

@Composable
fun Hi() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OtpView(
            otpUiState = OtpUiState(
                otpLength = 6
            ),
            onValueChange = {
            }
        )
    }
}

data class OtpUiState(
    val otpLength: Int = 4,
    val otp: String = "",
    val error: Boolean = false,
    val errorMsg: String? = null,
    val cellWidth: Dp = 50.dp,
    val cellHeight: Dp = 42.dp,
    val enabled: Boolean = true,
    val spaceBetween: Dp = 8.dp
)

@Composable
private fun OtpCell(
    modifier: Modifier,
    value: String,
    isCursorVisible: Boolean = false
) {
    val scope = rememberCoroutineScope()
    val (cursorSymbol, setCursorSymbol) = remember { mutableStateOf("") }
    LaunchedEffect(key1 = cursorSymbol, isCursorVisible) {
        if (isCursorVisible) {
            scope.launch {
                delay(350)
                setCursorSymbol(if (cursorSymbol.isEmpty()) "|" else "")
            }
        }
    }
    Box(
        modifier = modifier.border(
            border = BorderStroke(
                1.dp,
                if (isCursorVisible || value.isEmpty()) black_60 else redDark
            ),
            shape = RoundedCornerShape(80.dp)
        )
    ) {
        Text(
            text = if (isCursorVisible) cursorSymbol else if (value.isNotEmpty()) "•" else value,
            style = MaterialTheme.typography.titleSmall.copy(
                fontSize = 16.sp,
                color = if (isCursorVisible || value.isEmpty()) {
                    black_60
                } else {
                    redDark
                }
            ),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun OtpView(
    otpUiState: OtpUiState = OtpUiState(),
    onValueChange: (String) -> Unit = {},
    keyboardAlwaysOn: Boolean = false
) {
    var textFieldValueState by remember {
        mutableStateOf(
            TextFieldValue(
                otpUiState.otp,
                selection = if (otpUiState.otp.isNotEmpty()) TextRange(otpUiState.otp.length) else TextRange.Zero
            )
        )
    }
    val otpLength = remember { otpUiState.otpLength }
    val focusRequester = remember { FocusRequester() }
    val keyboard = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    TextField(
        value = textFieldValueState,
        onValueChange = { tv ->
            if (tv.text.length <= otpLength) {
                textFieldValueState = tv
                onValueChange(tv.text)
            }
        },
        modifier = Modifier
            .size(1.dp)
            .focusRequester(focusRequester),
        keyboardActions = KeyboardActions {
            if (!keyboardAlwaysOn) {
                focusManager.clearFocus()
            } else {
                focusRequester.requestFocus()
                keyboard?.show()
            }
        },
        enabled = otpUiState.enabled,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = androidx.compose.ui.text.input.ImeAction.Done
        ),
    )
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            (0 until otpLength).map { index ->
                OtpCell(
                    modifier = Modifier
                        .height(otpUiState.cellHeight)
                        .width(otpUiState.cellWidth)
                        .clip(shape = RoundedCornerShape(80.dp))
                        .clickable {
                            focusRequester.requestFocus()
                            keyboard?.show()
                        },
                    value = textFieldValueState.text.getOrNull(index)?.toString() ?: "",
                    isCursorVisible = textFieldValueState.text.length == index,
                )
            }
        }
        if (!otpUiState.errorMsg.isNullOrEmpty()) {
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = otpUiState.errorMsg,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.weight(0.8F)
            )
        }
    }
    LaunchedEffect(keyboardAlwaysOn) {
        if (keyboardAlwaysOn) {
            focusRequester.requestFocus()
            keyboard?.show()
        }
    }
}
