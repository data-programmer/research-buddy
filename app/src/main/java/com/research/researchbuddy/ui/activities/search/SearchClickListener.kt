package com.research.researchbuddy.ui.activities.search

interface SearchClickListener {
    fun onSearchItemClick(
        title: String,
        year: String,
        author: String,
        abstract: String
    )
}