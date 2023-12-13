package com.example.financeapplication

import android.content.Context
import androidx.room.Room

object FinanceDataBaseBuilder {
    private var INSTANCE: FinanceDataBase? = null

    fun getInstance(context: Context): FinanceDataBase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                FinanceDataBase::class.java,
                "app_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }

}