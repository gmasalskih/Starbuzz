package com.example.gmasalskih.starbuzz

val drinks: List<Drink> = listOf(
        Drink(
                "Latte",
                "A couple of espresso shots with steamed milk",
                R.drawable.latte
        ),
        Drink(
                "Cappuccino",
                "Espresso, hot milk, and a steamed milk foam",
                R.drawable.cappuccino
        ),
        Drink(
                "Filter",
                "Highest quality beans roasted and brewed fresh",
                R.drawable.filter
        )
)

data class Drink(val name: String, val description: String, val imageResourceId: Int) {
    override fun toString() = name
}