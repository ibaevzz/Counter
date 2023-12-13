package com.ibaevzz.counter.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(version = 1, entities = [CounterEntity::class])
@TypeConverters(DateConverter::class)
abstract class CounterDatabase: RoomDatabase() {
    abstract fun getCounterDao(): CounterDao
}