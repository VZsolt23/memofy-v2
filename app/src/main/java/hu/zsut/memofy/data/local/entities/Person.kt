package hu.zsut.memofy.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.MonthDay

@Entity(tableName = "persons")
data class Person (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val birthDay: MonthDay,
    val nameDay: MonthDay
)