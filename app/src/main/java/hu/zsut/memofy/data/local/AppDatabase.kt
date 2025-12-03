package hu.zsut.memofy.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hu.zsut.memofy.data.local.entities.Person
import hu.zsut.memofy.data.local.dao.PersonDao
import hu.zsut.memofy.data.converters.MonthDayConverter

@Database(entities = [Person::class], version = 2)
@TypeConverters(MonthDayConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun personDao(): PersonDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(contenxt: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    contenxt.applicationContext,
                    AppDatabase::class.java,
                    "my_fav_people"
                ).fallbackToDestructiveMigration(true).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}