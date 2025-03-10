package com.example.newsv1.domain.constants

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.newsv1.R


data class Category(
    val id: String,
    @StringRes
    val title: Int,
    @DrawableRes
    val imgRes: Int,
) {
    companion object {
        fun getCategories(): List<Category> {
            return listOf(
                Category("general", R.string.general, R.drawable.planet),
                Category("business", R.string.business, R.drawable.business),
                Category("sports", R.string.sports, R.drawable.sport),
                Category("health", R.string.health, R.drawable.health),
                Category("science", R.string.science, R.drawable.science),
                Category("entertainment", R.string.entertainment, R.drawable.entertainment),
                Category("technology", R.string.tech, R.drawable.technology),
            )
        }
        const val CATEGORY_KEY = "categoryId"
    }
}
