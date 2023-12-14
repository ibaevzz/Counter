package com.ibaevzz.counter.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibaevzz.counter.db.CounterRepository
import com.ibaevzz.counter.entity.Count
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel: ViewModel() {
    private val countFlow = MutableStateFlow(0)
    private var count: Count? = null

    fun getCount(): StateFlow<Int>{
        updateCount()
        return countFlow
    }

    fun updateCount(){
        viewModelScope.launch {
            count = CounterRepository.getCount(Date())
            if(count == null){
                count = Count(Date())
                CounterRepository.addCount(count!!.toCounterEntity())
            }
            countFlow.emit(count!!.count)
        }
    }

    fun plus(){
        viewModelScope.launch {
            if(count==null){
                updateCount()
            }
            count!!.count += 1
            CounterRepository.updateCount(count!!.toCounterEntity())
            updateCount()
        }
    }

    fun minus(){
        viewModelScope.launch {
            if(count==null){
                updateCount()
            }
            if(count!!.count>0){
                count!!.count -= 1
                CounterRepository.updateCount(count!!.toCounterEntity())
                updateCount()
            }
        }
    }
}