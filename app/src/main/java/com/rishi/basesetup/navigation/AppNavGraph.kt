package com.rishi.basesetup.navigation

import FailurePayment
import SuccessPayment
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.rishi.basesetup.animation.PaymentAnimation
import com.rishi.basesetup.screen.exampledetail.ExampleDetailScreen
import com.rishi.basesetup.screen.exampleui.ExampleScreen
import com.rishi.basesetup.utils.animatedComposable

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = AppScreen.ExampleScreen.route,
    navActions: AppNavigationActions,
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        animatedComposable(AppScreen.ExampleScreen.route) {
            ExampleScreen(
                onAction = navActions::navigateFromExampleScreen
            )
        }
        composable(AppScreen.TestScreen.route) {
//            TestScreen(
//                onAction = navActions::navigateFromTestScreen
//            )
        }

        animatedComposable(
            route = AppScreen.ExampleDetailsScreen.route,
            arguments = listOf(
                navArgument(AppArgs.ARG_NEWS_ID) { type = NavType.StringType }
            )
        ) {
            ExampleDetailScreen(
                onAction = navActions::navigateFromExampleDetailScreen
            )
        }
    }
}


@Composable
fun AppNavGraph2(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = AppScreen.PaymentAnimation.route,
    navActions: AppNavigationActions,
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(AppScreen.PaymentAnimation.route) {
            PaymentAnimation(navActions::navigateFrommPaymentScreen)
        }
        composable(AppScreen.SuccessPaymentScreen.route) {
            SuccessPayment()
        }
        animatedComposable(AppScreen.FailurePaymentScreen.route) {
            FailurePayment()
        }
    }
}