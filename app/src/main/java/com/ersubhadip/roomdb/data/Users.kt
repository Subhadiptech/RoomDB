package com.ersubhadip.roomdb.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class Users(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var name: String,
    var reg: String,
    var phnNumber: Int
)