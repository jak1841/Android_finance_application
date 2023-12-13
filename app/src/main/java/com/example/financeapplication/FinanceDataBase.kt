package com.example.financeapplication

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserFinance::class], version = 1, exportSchema = false)
abstract class FinanceDataBase : RoomDatabase() {
    abstract fun financeUserDao(): UserFinanceDAO
}
