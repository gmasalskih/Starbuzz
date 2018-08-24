package com.example.gmasalskih.starbuzz

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class StarbuzzDatabaseHelper : SQLiteOpenHelper {

    constructor(context: Context) : super(context, DB_NAME, null, DB_VERSION)

    companion object {

        const val DB_NAME = "starbuzz"
        const val DB_VERSION = 1

        private fun insertDrink(db: SQLiteDatabase, name: String, description: String, resourceId: Int) {
            Log.d("DB", "insertDrink")
            val drinkValues = ContentValues().apply {
                put("NAME", name)
                put("DESCRIPTION", description)
                put("IMAGE_RESOURCE_ID", resourceId)
            }
            db.insert("DRINK", null, drinkValues)
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        updateMyDatabase(db, 0, 1)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        updateMyDatabase(db, 0, 1)
    }

    private fun updateMyDatabase(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);")
            drinks.forEach {
                insertDrink(db, it.name, it.description, it.imageResourceId)
            }
            Log.d("DB", "oldVersion < 1")
        }
        if(oldVersion < 2){
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;")
            Log.d("DB", "oldVersion < 2")
        }
    }
}