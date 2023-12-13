package com.ibaevzz.counter.db

import android.content.Context
import androidx.room.Room
import com.ibaevzz.counter.entity.Count
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

object CounterRepository {
    private lateinit var applicationContext: Context
    private val database by lazy{
        Room.databaseBuilder(applicationContext, CounterDatabase::class.java, "counter_db").build()
    }
    private val counterDao by lazy{
        database.getCounterDao()
    }

    fun init(context: Context) {
        applicationContext = context
    }

    suspend fun addCount(count: CounterEntity){
        withContext(Dispatchers.IO){
            counterDao.addCount(count)
        }
    }

    suspend fun updateCount(count: CounterEntity){
        withContext(Dispatchers.IO){
            counterDao.updateCount(count)
        }
    }

    suspend fun getAllCounts(): List<Count>{
        return withContext(Dispatchers.IO){
            return@withContext counterDao.getAllCounts()
        }
    }

    suspend fun getCount(date: Date): Count?{
        return withContext(Dispatchers.IO){
            return@withContext counterDao.getCount(date)
        }
    }

    suspend fun deleteAllCount(){
        withContext(Dispatchers.IO){
            counterDao.deleteAllCount()
        }
    }
}