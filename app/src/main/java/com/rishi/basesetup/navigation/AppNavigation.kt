package com.rishi.basesetup.navigation

import com.rishi.basesetup.navigation.AppArgs.ARG_NEWS_ID
import com.rishi.basesetup.utils.addRouteArgument


/**
 * Args irrespective of screens are kept here
 */
object AppArgs {
    const val ARG_NEWS_ID = "news_Id"
}

sealed class AppScreen(val name: String, val route: String) {
    data object TestScreen : AppScreen("test", "test")
    data object ExampleScreen : AppScreen("example", "example")
    data object ExampleDetailsScreen : AppScreen(
        "exampleDetail", "exampleDetail"
            .addRouteArgument(ARG_NEWS_ID)
    )
}