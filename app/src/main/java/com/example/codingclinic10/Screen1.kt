package com.example.codingclinic10

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.presentation.MainViewModel

@Composable
fun Screen1(modifier: Modifier, viewModel: MainViewModel)  {

    val state1 by viewModel.state.collectAsStateWithLifecycle()


    var input by remember { mutableStateOf("") }

    Column() {
        OutlinedTextField(value = input, onValueChange = { input = it }, placeholder = { Text("Please enter input here")} )

        Text("This is a title", modifier = Modifier.padding(top = 30.dp), fontSize = 30.sp, fontWeight = FontWeight.Bold)

        RadioButtonSingleSelection()

    }
}

@Composable
fun RadioButtonSingleSelection(modifier: Modifier = Modifier) {
    val radioOptions = listOf("Option A", "Option B", "Option C")
    val (selectedOption, onOptionsSelected) = remember { mutableStateOf(radioOptions[0])}

    Column(modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            Row(
                Modifier.fillMaxWidth().height(56.dp).selectable(
                    selected = (text == selectedOption),
                    onClick = { onOptionsSelected(text) },
                    role = Role.RadioButton
                )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null
                )
                Text(text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp))

            }
        }
    }
}