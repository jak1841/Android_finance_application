package com.example.financeapplication

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*


// Purpose of this class is to build the table in database where the
@Entity(tableName = "userfinance")
data class UserFinance (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val amount: Int,
    val category: String,
    val date: String,
)