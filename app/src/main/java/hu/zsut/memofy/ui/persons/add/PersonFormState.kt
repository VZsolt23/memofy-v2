package hu.zsut.memofy.ui.persons.add

data class PersonFormState(
    val name: String = "",
    val birthMonth: String = "",
    val birthDay: String = "",
    val nameMonth: String = "",
    val nameDay: String = "",

    val nameError: String? = null,
    val birthMonthError: String? = null,
    val birthDayError: String? = null,
    val nameMonthError: String? = null,
    val nameDayError: String? = null
)