package com.angelorobson.to_do_compose.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.angelorobson.to_do_compose.data.models.Priority
import com.angelorobson.to_do_compose.data.models.ToDoTask
import com.angelorobson.to_do_compose.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = {
            TaskContent(
                title = "",
                onTitleChange = {},
                description = "",
                onDescriptionChange = {},
                priority = Priority.LOW,
                onPrioritySelected = {}
            )
        }
    )
}