package com.ibaevzz.counter.db

import androidx.room.*
import com.ibaevzz.counter.entity.Count
import java.util.Date

@Dao
interface CounterDao {
    @Insert
    fun addCount(count: CounterEntity)

    @Update
    fun updateCount(count: CounterEntity)

    @Query("SELECT count, date FROM counter")
    fun getAllCounts(): List<Count>

    @Query("SELECT count, date FROM counter WHERE date = :date")
    fun getCount(date: Date): Count?

    @Query("DELETE FROM counter")
    fun deleteAllCount()
}