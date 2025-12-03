package hu.zsut.memofy.data.mapper

import hu.zsut.memofy.data.local.entities.Person
import hu.zsut.memofy.ui.persons.list.PersonUi
import java.time.format.DateTimeFormatter
import java.util.Locale

private val formatter = DateTimeFormatter.ofPattern("MMM d.", Locale.forLanguageTag("hu"))

fun Person.toUi(): PersonUi = PersonUi(
    id = id,
    name = name,
    birthdayString = birthDay.format(formatter),
    namedayString = nameDay.format(formatter)
)
