package com.ibaevzz.counter.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "counter")
data class CounterEntity(@PrimaryKey val date: Date,
                         val count: Int = 0)