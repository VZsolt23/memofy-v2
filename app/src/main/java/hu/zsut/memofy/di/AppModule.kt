package hu.zsut.memofy.di

import hu.zsut.memofy.data.local.AppDatabase
import hu.zsut.memofy.data.local.dao.PersonDao
import hu.zsut.memofy.data.repository.PersonRepository
import hu.zsut.memofy.ui.persons.add.AddPersonViewModel
import hu.zsut.memofy.ui.persons.list.PersonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Database
    single {
        AppDatabase.getDatabase(get())
    }

    // DAO
    single<PersonDao> {
        get<AppDatabase>().personDao()
    }

    // Repository
    single {
        PersonRepository(get())
    }

    // ViewModels
    viewModel {
        PersonListViewModel(get())
    }

    viewModel {
        AddPersonViewModel(get())
    }

//    viewModel { params ->
//        PersonDetailViewModel(
//            personId = params.get(),
//            repository = get()
//        )
//    }
}
