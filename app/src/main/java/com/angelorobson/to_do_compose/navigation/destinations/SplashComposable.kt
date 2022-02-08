package com.angelorobson.to_do_compose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.angelorobson.to_do_compose.ui.screens.splash.SplashScreen
import com.angelorobson.to_do_compose.util.Constants


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.splashComposable(
    navigateTaskScreen: () -> Unit,
) {
    composable(
        route = Constants.SPLASH_SCREEN,
        exitTransition = { _, _ ->
            slideOutVertically(
                targetOffsetY = { fullHigh -> -fullHigh },
                animationSpec = tween(300)
            )
        }
    ) {
        SplashScreen(navigateToListScreen = navigateTaskScreen)
    }
}