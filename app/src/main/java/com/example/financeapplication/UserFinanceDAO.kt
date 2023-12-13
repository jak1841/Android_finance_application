package com.example.financeapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserFinanceDAO {
    @Query("SELECT * FROM userfinance")
    fun getAllUsers(): List<UserFinance>

    @Insert
    fun insertUser(user: UserFinance)

    // Add other database operations as needed

}