package com.ersubhadip.roomdb.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    //We will access the query from the dao as this is the data source for views

    //Room do not use simple ViewModel class instead it uses AndroidViewModel

    private var getAllData: LiveData<List<Users>>
    private var repository: UserRepository

    init {
        val daoVM = UserDatabase.getDataBase(application).userDao()
        repository = UserRepository(daoVM)
        getAllData = repository.readAllData
    }

    fun addUser(user: Users) {

        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

}