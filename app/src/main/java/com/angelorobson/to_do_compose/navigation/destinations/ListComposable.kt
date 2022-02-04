package com.angelorobson.to_do_compose.navigation.destinations

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.angelorobson.to_do_compose.ui.screens.list.ListScreen
import com.angelorobson.to_do_compose.ui.viewmodels.SharedViewModel
import com.angelorobson.to_do_compose.util.Constants.LIST_ARGUMENT_KEY
import com.angelorobson.to_do_compose.util.Constants.LIST_SCREEN

@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        ListScreen(
            navigateTaskScreen = navigateTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}