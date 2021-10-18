package com.ranzan.and_03unit_41evaluation_i.Database

import android.content.ContentValues
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
            "CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY," +
                    "$EventName text," +
                    "$EventDesc text," +
                    "$EventDate text," +
                    "$EventLocation text," +
                    "$event_price INTEGER)"
        p0?.execSQL(res)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun addDBData(
        name: String,
        date: String,
        location: String,
        desc: String,
        price: Int
    ) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(EventName, name)
        values.put(EventDate, date)
        values.put(EventLocation, location)
        values.put(EventDesc, desc)
        values.put(event_price, price)
        db.insert(TABLE_NAME, null, values)
    }

    fun getDBList(): MutableList<DatabaseModel> {
        var list = mutableListOf<DatabaseModel>()
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null)
        if (cursor != null && cursor.count > 0) {
            cursor.moveToFirst()
            val idIndex=cursor.getColumnIndex(ID)
            val nameIndex=cursor.getColumnIndex(EventName)
            val dateIndex=cursor.getColumnIndex(EventDate)
            val descIndex=cursor.getColumnIndex(EventDesc)
            val locationIndex=cursor.getColumnIndex(EventLocation)
            do {
                val id=cursor.getInt(idIndex)
                val name=cursor.getString(nameIndex)
                val date=cursor.getString(dateIndex)
                val desc=cursor.getString(descIndex)


            } while (cursor.moveToNext())
        }
        return list

    }
}