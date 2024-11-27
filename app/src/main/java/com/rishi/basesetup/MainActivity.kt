package com.rishi.basesetup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.rishi.basesetup.animation.PaymentAnimation
import com.rishi.basesetup.navigation.AppNavGraph
import com.rishi.basesetup.navigation.AppNavGraph2
import com.rishi.basesetup.navigation.AppNavigationActions
import com.rishi.basesetup.ui.theme.BaseSetupTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            BaseSetupTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph(onNavigationEnd = {

                    })
                }
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
