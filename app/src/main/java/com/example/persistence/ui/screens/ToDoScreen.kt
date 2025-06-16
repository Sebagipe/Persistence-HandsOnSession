package com.example.persistence.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.persistence.model.database.entities.Todo
import com.example.persistence.viewmodels.ToDoViewModel

@Composable
fun ToDoScreen(
    modifier: Modifier = Modifier,
    viewModel: ToDoViewModel = viewModel<ToDoViewModel>(),
) {
    //TODO 5
    val incompleteEntries by viewModel.incompleteEntries.observeAsState(emptyList())
    val completedEntries by viewModel.completedEntries.observeAsState(emptyList())

    ToDoScreen(
        modifier,
        incompleteEntries = incompleteEntries,
        completedEntries = completedEntries,
        toggleDone = { viewModel.toggleDone(it) },
        onDelete = { viewModel.deleteEntry(it) },
        onSave = { viewModel.saveEntry(it) })
}

@Composable
fun ToDoScreen(
    modifier: Modifier = Modifier,
    incompleteEntries: List<Todo>,
    completedEntries: List<Todo>,
    toggleDone: (entry: Todo) -> Unit,
    onDelete: (entry: Todo) -> Unit,
    onSave: (name: String) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        AddItemRow(onSave)
        AllTodos(
            incompleteEntries = incompleteEntries,
            completedEntries = completedEntries,
            toggleDone,
            onDelete
        )
    }
}

@Composable
@Preview
fun EmptyTodoScreenPreview() {
    ToDoScreen(Modifier, emptyList(), emptyList(), {}, {}, {})
}

@Composable
fun AddItemRow(onSave: (todoName: String) -> Unit) {
    Row(
        modifier = Modifier.padding(20.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        var todoName by remember { mutableStateOf("") }
        OutlinedTextField(
            value = todoName, onValueChange = { todoName = it }, modifier = Modifier.weight(3F)
        )
        Button(
            onClick = { onSave(todoName) }, modifier = Modifier.weight(1F)
        ) {
            Text(text = "Add")
        }
    }
}

@Composable
fun AllTodos(
    incompleteEntries: List<Todo>,
    completedEntries: List<Todo>,
    toggleDone: (entry: Todo) -> Unit,
    onDelete: (entry: Todo) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        stickyHeader { Text(text = "Pending ToDos:") }
        items(incompleteEntries) { entry ->
            TodoRow(entry, toggleDone, onDelete)
        }
        stickyHeader {
            Text(text = "Completed ToDos:")
        }
        items(completedEntries) { entry ->
            TodoRow(entry, toggleDone, onDelete)
        }
    }
}

@Composable
@Preview
fun AllTodosPreview() {
    AllTodos(
        incompleteEntries = listOf(
        Todo("incomplete 1", false), Todo("incomplete 2", false)
    ), completedEntries = listOf(
        Todo("complete 1", true), Todo("complete 2", true)
    ), {}, {})
}

@Composable
fun TodoRow(
    entry: Todo, toggleDone: (entry: Todo) -> Unit, onDelete: (entry: Todo) -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = entry.name, fontSize = 20.sp)
        }
        Checkbox(
            checked = entry.completed, onCheckedChange = { toggleDone(entry) })
        IconButton(onClick = { onDelete(entry) }) {
            Icon(
                imageVector = Icons.Default.Delete, contentDescription = "Delete todo"
            )
        }
    }
}

@Composable
@Preview
fun TodoRowPreview() {
    TodoRow(Todo("Sample Todo", true, 0), {}) { }
}