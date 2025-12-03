package hu.zsut.memofy.data.repository

import hu.zsut.memofy.data.local.dao.PersonDao
import hu.zsut.memofy.data.local.entities.Person
import kotlinx.coroutines.flow.Flow

class PersonRepository(private val personDao: PersonDao) {

    val allPerson: Flow<List<Person>> = personDao.getAllPersons()

    suspend fun addPerson(person: Person) {
        personDao.insertPerson(person)
    }

    suspend fun updatePerson(person: Person) {
        personDao.updatePerson(person)
    }

    suspend fun deletePerson(person: Person) {
        personDao.deletePerson(person)
    }

    suspend fun getPerson(id: Int): Person? {
        return personDao.getPersonById(id)
    }
}