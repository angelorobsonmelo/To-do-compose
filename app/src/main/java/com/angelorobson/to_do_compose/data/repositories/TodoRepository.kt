package com.angelorobson.to_do_compose.data.repositories

import com.angelorobson.to_do_compose.data.TodoDao
import com.angelorobson.to_do_compose.data.models.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class TodoRepository @Inject constructor(private val todoDao: TodoDao) {

    val getAllTasks: Flow<List<ToDoTask>> = todoDao.getAllTasks()
    val sortByLowPriority: Flow<List<ToDoTask>> = todoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<ToDoTask>> = todoDao.sortByHighPriority()

    suspend fun addTask(toDoTask: ToDoTask) = todoDao.addTask(toDoTask)
    suspend fun updateTask(toDoTask: ToDoTask) = todoDao.updateTask(toDoTask)
    suspend fun deleteTask(toDoTask: ToDoTask) = todoDao.deleteTask(toDoTask)
    suspend fun deleteAllTask() = todoDao.deleteAllTasks()

    fun getSelectedTask(taskId: Int) = todoDao.getSelectedTask(taskId)
    fun searchDatabase(searchQuery: String) = todoDao.searchDatabase(searchQuery)


}