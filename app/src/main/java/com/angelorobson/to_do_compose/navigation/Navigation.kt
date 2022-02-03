package com.angelorobson.to_do_compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.angelorobson.to_do_compose.navigation.destinations.listComposable
import com.angelorobson.to_do_compose.navigation.destinations.taskComposable
import com.angelorobson.to_do_compose.ui.viewmodels.SharedViewModel
import com.angelorobson.to_do_compose.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            navigateTaskScreen = screen.task,
            sharedViewModel
        )

        taskComposable(
            navigateToListScreen = screen.list
        )
    }
}