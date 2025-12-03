package hu.zsut.memofy.ui.persons.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.zsut.memofy.data.mapper.toUi
import hu.zsut.memofy.data.repository.PersonRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class PersonListViewModel(private val repository: PersonRepository) : ViewModel() {

    val persons: StateFlow<List<PersonUi>> = repository.allPerson
        .map { list -> list.map { it.toUi() } }
        .distinctUntilChanged()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )
}