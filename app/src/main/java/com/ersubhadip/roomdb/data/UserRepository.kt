package com.ersubhadip.roomdb.data

import androidx.lifecycle.LiveData

class UserRepository(val dao:userInterfaceDao) {

    var readAllData:LiveData<List<Users>> = dao.readAllDataFromDB()

    suspend fun addUser(user:Users){
        dao.addDataToDB(user)
    }
}