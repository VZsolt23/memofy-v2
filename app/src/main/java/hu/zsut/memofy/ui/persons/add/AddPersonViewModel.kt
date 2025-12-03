package hu.zsut.memofy.ui.persons.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.zsut.memofy.core.events.EventEmitter
import hu.zsut.memofy.core.validation.isValidDayForMonth
import hu.zsut.memofy.core.validation.isValidMonth
import hu.zsut.memofy.data.local.entities.Person
import hu.zsut.memofy.data.repository.PersonRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import java.time.MonthDay

class AddPersonViewModel(private val repository: PersonRepository) : ViewModel(), EventEmitter {

    var state by mutableStateOf(PersonFormState())
        private set

    fun onNameChange(value: String) {
        state = state.copy(name = value)
    }

    fun onBirthMonthChange(value: String) {
        state = state.copy(birthMonth = limitToTwoDigits(value))
    }

    fun onBirthDayChange(value: String) {
        state = state.copy(birthDay = limitToTwoDigits(value))
    }

    fun onNameMonthChange(value: String) {
        state = state.copy(nameMonth = limitToTwoDigits(value))
    }

    fun onNameDayChange(value: String) {
        state = state.copy(nameDay = limitToTwoDigits(value))
    }

    var toastMsg by mutableStateOf("")

    private val _saveEvent = MutableSharedFlow<Unit>()
    override val toastEvent = _saveEvent

    fun save() = viewModelScope.launch {
        try {
            if (!validate()) {
                return@launch
            }

            val birth = MonthDay.of(
                state.birthMonth.toInt(),
                state.birthDay.toInt()
            )
            val nameDay = MonthDay.of(
                state.nameMonth.toInt(),
                state.nameDay.toInt()
            )

            repository.addPerson(
                Person(
                    name = state.name,
                    birthDay = birth,
                    nameDay = nameDay
                )
            )

            toastMsg = "Sikeres mentés!"
            _saveEvent.emit(Unit)
        } catch (_: Error) {
            toastMsg = "Sikertelen mentés!"
            _saveEvent.emit(Unit)
        }
    }

    fun validate(): Boolean {
        val nameError = if (state.name.isBlank()) "A név nem lehet üres" else null

        val birthMonthError = if (!isValidMonth(state.birthMonth)) "Érvénytelen hónap" else null
        val birthDayError =
            if (!isValidDayForMonth(state.birthDay, state.birthMonth)) "Érvénytelen nap" else null

        val nameMonthError = if (!isValidMonth(state.nameMonth)) "Érvénytelen hónap" else null
        val nameDayError =
            if (!isValidDayForMonth(state.nameDay, state.nameMonth)) "Érvénytelen nap" else null

        state = state.copy(
            nameError = nameError,
            birthMonthError = birthMonthError,
            birthDayError = birthDayError,
            nameMonthError = nameMonthError,
            nameDayError = nameDayError
        )

        return listOf(
            nameError,
            birthMonthError,
            birthDayError,
            nameMonthError,
            nameDayError
        ).all { it == null }
    }

    private fun limitToTwoDigits(input: String): String {
        return input
            .filter { it.isDigit() }
            .take(2)
    }
}