package com.angelorobson.to_do_compose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.angelorobson.to_do_compose.data.models.ToDoTask

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao
}