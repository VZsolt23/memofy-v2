package hu.zsut.memofy.data.converters

import androidx.room.TypeConverter
import java.time.MonthDay

class MonthDayConverter {
    @TypeConverter
    fun fromMonthDay(monthDay: MonthDay?): String? {
        return monthDay?.toString()  // "--03-05"
    }

    @TypeConverter
    fun toMonthDay(value: String?): MonthDay? {
        return value?.let { MonthDay.parse(it) }
    }
}