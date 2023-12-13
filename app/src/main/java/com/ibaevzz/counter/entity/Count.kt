package com.ibaevzz.counter.entity

import com.ibaevzz.counter.db.CounterEntity
import java.util.Date

data class Count(val date: Date, var count: Int = 0){
    fun toCounterEntity(): CounterEntity {
        return CounterEntity(date, count)
    }
}