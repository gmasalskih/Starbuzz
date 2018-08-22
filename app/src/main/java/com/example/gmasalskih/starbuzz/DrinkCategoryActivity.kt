package com.example.gmasalskih.starbuzz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_drink_category.*

class DrinkCategoryActivity : AppCompatActivity() {

    private lateinit var coffeeItemsView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_category)
        coffeeItemsView = coffee_items_view
        coffeeItemsView.adapter = ArrayAdapter<Drink>(
                this,
                android.R.layout.simple_list_item_1,
                drinks
        )
        coffeeItemsView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DrinkActivity::class.java)
            intent.putExtra(DrinkActivity.DRINK_ITEM_POSITION, position)
            startActivity(intent)
        }
    }
}
