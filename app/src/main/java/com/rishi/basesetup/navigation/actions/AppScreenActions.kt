package com.rishi.basesetup.navigation.actions


/**
 * Add all you app screen actions here ====================================
 */

sealed class ScreenActions

sealed class ExampleScreenActions : ScreenActions() {
    data object OnHelp : ExampleScreenActions()
    data object OnBack : ExampleScreenActions()
    data class OpenExampleDetailScreen(
        val newsId: String
    ) : ExampleScreenActions()
}

sealed class ExampleDetailScreenActions : ScreenActions() {
    data object OnBack : ExampleDetailScreenActions()
}

sealed class TestScreenActions : ScreenActions() {
    data object OpenExampleScreen : TestScreenActions()
}


