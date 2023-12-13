package com.ibaevzz.counter.db

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date

class DateConverter {
    @TypeConverter
    fun toDate(date: String): Date {
        return SimpleDateFormat("ddMMyyyy", Locale.ENGLISH).parse(date)
    }
    @TypeConverter
    fun toString(date: Date): String {
        return SimpleDateFormat("ddMMyyyy", Locale.ENGLISH).format(date)
    }
}