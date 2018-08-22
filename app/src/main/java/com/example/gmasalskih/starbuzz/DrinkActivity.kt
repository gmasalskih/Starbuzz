package com.example.gmasalskih.starbuzz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_drink.*

class DrinkActivity : AppCompatActivity() {

    private lateinit var photoView: ImageView
    private lateinit var nameView: TextView
    private lateinit var descriptionView: TextView

    companion object {
        const val DRINK_ITEM_POSITION = "DRINK_ITEM_POSITION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink)
        photoView = photo
        nameView = name
        descriptionView = description

        drinks[intent.extras.getInt(DRINK_ITEM_POSITION)].apply {
            photoView.setImageResource(imageResourceId)
            nameView.text = name
            descriptionView.text = description
        }
    }
}
