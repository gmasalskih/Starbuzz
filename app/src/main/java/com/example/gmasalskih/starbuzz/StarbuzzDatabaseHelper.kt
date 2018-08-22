package com.example.gmasalskih.starbuzz

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class StarbuzzDatabaseHelper(context: Context)
    : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {

        const val DB_NAME = "starbuzz"
        const val DB_VERSION = 1

        private fun insertDrink(db: SQLiteDatabase, name: String, description: String, resourceId: Int) {
            val drinkValues = ContentValues().apply {
                put("NAME", name)
                put("DESCRIPTION", description)
                put("IMAGE_RESOURCE_ID", resourceId)
            }
            db.insert("DRINK", null, drinkValues)
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "DESCRIPTION TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented")
    }
}