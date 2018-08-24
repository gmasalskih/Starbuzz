package com.example.gmasalskih.starbuzz

import android.database.SQLException
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_drink.*

class DrinkActivity : AppCompatActivity() {

    private lateinit var photoView: ImageView
    private lateinit var nameView: TextView
    private lateinit var descriptionView: TextView
    private lateinit var starbuzzDatabaseHelper: StarbuzzDatabaseHelper

    companion object {
        const val DRINK_ITEM_POSITION = "DRINK_ITEM_POSITION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink)
        photoView = photo
        nameView = name
        descriptionView = description

        try {
            starbuzzDatabaseHelper = StarbuzzDatabaseHelper(this)
            val db = starbuzzDatabaseHelper.readableDatabase
            val cursor = db.query(
                    "DRINK",
                    arrayOf("NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"),
                    "_ID = ?",

                    arrayOf((intent.extras.getInt(DRINK_ITEM_POSITION)+1).toString()),
                    null, null, null
            )
            Log.d("DB" , intent.extras.getInt(DRINK_ITEM_POSITION).toString())
            if (cursor.moveToFirst()) {
                Log.d("DB" , cursor.getString(0))
                nameView.text = cursor.getString(0)
                descriptionView.text = cursor.getString(1)
                photoView.setImageResource(cursor.getInt(2))
            }
            cursor.close()
            db.close()
        } catch (e: SQLException) {
            Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show()
        }

//        drinks[intent.extras.getInt(DRINK_ITEM_POSITION)].apply {
//            photoView.setImageResource(imageResourceId)
//            nameView.text = name
//            descriptionView.text = description
//        (intent.extras.getInt(DRINK_ITEM_POSITION)+1).toString()
//        }
    }
}
