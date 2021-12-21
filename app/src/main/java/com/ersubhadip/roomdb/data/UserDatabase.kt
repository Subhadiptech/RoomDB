package com.ersubhadip.roomdb.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): userInterfaceDao

    companion object{
        @Volatile
        private var INSTANCE:UserDatabase? =null

        fun getDataBase(context:Context):UserDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                var instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }

}