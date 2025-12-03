package hu.zsut.memofy.ui.persons.add

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import hu.zsut.memofy.ui.common.ShowToastMessage
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddPersonScreen(
    viewModel: AddPersonViewModel = koinViewModel()
) {

    val state = viewModel.state

    Column(
        Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // ----- NAME -----
        OutlinedTextField(
            value = state.name,
            onValueChange = viewModel::onNameChange,
            label = { Text("Név") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            isError = state.nameError != null,
            supportingText = {
                state.nameError?.let { Text(it, color = Color.Red) }
            }
        )

        // ----- BIRTHDAY -----
        Text("Születésnap", style = MaterialTheme.typography.titleMedium)

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedTextField(
                value = state.birthMonth,
                onValueChange = viewModel::onBirthMonthChange,
                label = { Text("Hónap") },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                isError = state.birthMonthError != null,
                supportingText = {
                    state.birthMonthError?.let { Text(it, color = Color.Red) }
                }
            )

            OutlinedTextField(
                value = state.birthDay,
                onValueChange = viewModel::onBirthDayChange,
                label = { Text("Nap") },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                isError = state.birthDayError != null,
                supportingText = {
                    state.birthDayError?.let { Text(it, color = Color.Red) }
                }
            )
        }

        // ----- NAMEDAY -----
        Text("Névnap", style = MaterialTheme.typography.titleMedium)

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedTextField(
                value = state.nameMonth,
                onValueChange = viewModel::onNameMonthChange,
                label = { Text("Hónap") },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                isError = state.nameMonthError != null,
                supportingText = {
                    state.nameMonthError?.let { Text(it, color = Color.Red) }
                }
            )

            OutlinedTextField(
                value = state.nameDay,
                onValueChange = viewModel::onNameDayChange,
                label = { Text("Nap") },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                isError = state.nameDayError != null,
                supportingText = {
                    state.nameDayError?.let { Text(it, color = Color.Red) }
                }
            )
        }

        // ----- SAVE BUTTON -----
        Button(
            onClick = { viewModel.save() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Mentés")
        }

        ShowToastMessage(viewModel.toastMsg, Toast.LENGTH_SHORT, viewModel)
    }
}