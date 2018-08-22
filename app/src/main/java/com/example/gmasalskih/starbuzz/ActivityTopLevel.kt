package com.example.gmasalskih.starbuzz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_top_level.*

class ActivityTopLevel : AppCompatActivity() {

    private lateinit var mainMenuView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_level)
        mainMenuView = main_menu
        mainMenuView.setOnItemClickListener { adapterView, view, position, id ->
            when (position) {
                0 -> {
                    startActivity(Intent(this, DrinkCategoryActivity::class.java))
                }
                1 -> {

                }
                2 -> {

                }
            }
        }
    }
}

