package com.ranzan.and_03unit_41evaluation_i.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(private val context: Context) : SQLiteOpenHelper(context, "db", null, 1) {
    companion object {
        const val TABLE_NAME = "DATA"
        const val ID = "Id"
        const val EventName = "event_name"
        const val EventDesc = "event_desc"
        const val EventDate = "event_date"
        const val EventLocation = "event_location"
        const val event_price = "event_price"
    }

    //    n (Id, event_name, event_desc, event_date, event_location, event_price) - 2pts
    override fun onCreate(p0: SQLiteDatabase?) {
        val res =
            "CREATE TABLE $TABLE_NAME($ID PRIMARY KEY,$EventName,$EventDesc,$EventDate,$EventLocation,$event_price)"
        p0?.execSQL(res)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}