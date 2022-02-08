package com.angelorobson.to_do_compose.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.angelorobson.to_do_compose.R
import com.angelorobson.to_do_compose.ui.theme.LOGO_HEIGHT
import com.angelorobson.to_do_compose.ui.theme.splashScreenBackGroundColor
import com.angelorobson.to_do_compose.util.Constants.SPLASH_SCREEN_DELAY
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToListScreen: () -> Unit
) {
    LaunchedEffect(key1 = true) {
      delay(SPLASH_SCREEN_DELAY)
        navigateToListScreen()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.splashScreenBackGroundColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(LOGO_HEIGHT),
            painter = painterResource(id = GetLog()),
            contentDescription = stringResource(R.string.to_do_logo)
        )
    }
}

@Composable
fun GetLog(): Int = if (isSystemInDarkTheme()) R.drawable.ic_logo_dark else R.drawable.ic_logo_light

@Composable
@Preview
private fun SplashScreenPreview() {
    SplashScreen(navigateToListScreen = {})
}