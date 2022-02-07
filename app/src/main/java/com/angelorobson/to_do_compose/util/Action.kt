package com.angelorobson.to_do_compose.util

enum class Action {
    ADD,
    UPDATE,
    DELETE,
    DELETE_ALL,
    UNDO,
    NO_ACTION
}

fun String?.toAction(): Action {
    return when {
        this == Action.ADD.name -> {
            Action.ADD
        }
        this == Action.UPDATE.name -> {
            Action.UPDATE
        }
        this == Action.DELETE.name -> {
            Action.DELETE
        }
        this == Action.DELETE_ALL.name -> {
            Action.DELETE_ALL
        }
        this == Action.UNDO.name -> {
            Action.ADD
        }
        else -> {
            Action.NO_ACTION
        }
    }
}