package com.ersubhadip.roomdb.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface userInterfaceDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDataToDB(user:Users)

    @Query("SELECT * FROM users ORDER BY id ASC")
    fun readAllDataFromDB():LiveData<List<Users>>

}