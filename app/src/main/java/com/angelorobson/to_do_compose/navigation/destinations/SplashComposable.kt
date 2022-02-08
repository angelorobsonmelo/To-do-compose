package com.angelorobson.to_do_compose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.angelorobson.to_do_compose.ui.screens.splash.SplashScreen
import com.angelorobson.to_do_compose.util.Constants

fun NavGraphBuilder.splashComposable(
    navigateTaskScreen: () -> Unit,
) {
    composable(
        route = Constants.SPLASH_SCREEN,
    ) {
        SplashScreen(navigateToListScreen = navigateTaskScreen)
    }
}