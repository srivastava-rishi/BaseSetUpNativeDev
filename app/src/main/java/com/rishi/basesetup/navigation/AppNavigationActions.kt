package com.rishi.basesetup.navigation

import androidx.navigation.NavController
import com.rishi.basesetup.navigation.AppArgs.ARG_NEWS_ID
import com.rishi.basesetup.navigation.actions.ExampleDetailScreenActions
import com.rishi.basesetup.navigation.actions.ExampleScreenActions
import com.rishi.basesetup.navigation.actions.TestScreenActions
import com.rishi.basesetup.utils.withArg

class AppNavigationActions(
    private val navController: NavController,
    private val onFinish: () -> Unit
) {

    fun back() {
        navController.popBackStack()
    }

    private fun finishActivity() {
        onFinish()
    }

    // example navigation
    fun navigateFromExampleScreen(actions: ExampleScreenActions) {
        when (actions) {
            ExampleScreenActions.OnBack -> {
                back()
            }

            ExampleScreenActions.OnHelp -> {

            }

            is ExampleScreenActions.OpenExampleDetailScreen -> {
                navController.navigate(
                    AppScreen.ExampleDetailsScreen.name
                        .withArg(ARG_NEWS_ID, actions.newsId)
                )
            }
        }
    }

    fun navigateFromTestScreen(actions: TestScreenActions) {
        when (actions) {
            TestScreenActions.OpenExampleScreen -> {
                back()
            }
        }
    }

    fun navigateFromExampleDetailScreen(actions: ExampleDetailScreenActions) {
        when (actions) {
            ExampleDetailScreenActions.OnBack -> {
                back()
            }
        }
    }
}