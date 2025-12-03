package hu.zsut.memofy.core.validation

fun isValidMonth(input: String): Boolean =
    input.toIntOrNull() in 1..12

fun isValidDayForMonth(day: String, month: String): Boolean {
    val d = day.toIntOrNull() ?: return false
    val m = month.toIntOrNull() ?: return false

    val max = when (m) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 -> 29
        else -> return false
    }

    return d in 1..max
}
