package com.example.gmasalskih.starbuzz

import android.content.Intent
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SimpleCursorAdapter
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_drink_category.*
import java.util.ArrayList

class DrinkCategoryActivity : AppCompatActivity() {

    private lateinit var coffeeItemsView: ListView
    private lateinit var starbuzzDatabaseHelper: StarbuzzDatabaseHelper
    private lateinit var cursor: Cursor
    private lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_category)

        starbuzzDatabaseHelper = StarbuzzDatabaseHelper(this)

        try {
            db = starbuzzDatabaseHelper.readableDatabase
            cursor = db.query(
                    "DRINK",
                    arrayOf("_id", "NAME"),
                    null, null, null, null, null
            )
        } catch (e: SQLException) {
            Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show()
        }

//        val str = ArrayList<String>()
//        if (cursor.moveToFirst()){
//            do {
//                str.add(cursor.getString(1))
//            } while (cursor.moveToNext())
//        }

        coffeeItemsView = coffee_items_view
        coffeeItemsView.adapter = SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cursor,
                arrayOf("NAME"),
                intArrayOf(android.R.id.text1),
                0
        )
//        coffeeItemsView.adapter = ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                str
//        )
        coffeeItemsView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DrinkActivity::class.java)
            intent.putExtra(DrinkActivity.DRINK_ITEM_POSITION, position)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cursor.close()
        db.close()
    }
}
