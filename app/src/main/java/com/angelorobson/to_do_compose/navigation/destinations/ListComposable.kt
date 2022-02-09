package com.angelorobson.to_do_compose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.compose.navArgument
import com.angelorobson.to_do_compose.ui.screens.list.ListScreen
import com.angelorobson.to_do_compose.ui.viewmodels.SharedViewModel
import com.angelorobson.to_do_compose.util.Action
import com.angelorobson.to_do_compose.util.Constants.LIST_ARGUMENT_KEY
import com.angelorobson.to_do_compose.util.Constants.LIST_SCREEN
import com.angelorobson.to_do_compose.util.toAction

@OptIn(ExperimentalAnimationApi::class)
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
    ) { navBackScreenEntry ->

        val action = navBackScreenEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()

        var myAction by remember { mutableStateOf(Action.NO_ACTION) }

        LaunchedEffect(key1 = myAction) {
            if (action != myAction) {
                myAction = action
                sharedViewModel.action.value = action
            }
        }

        val databaseAction by sharedViewModel.action

        ListScreen(
            action = databaseAction,
            navigateTaskScreen = navigateTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}