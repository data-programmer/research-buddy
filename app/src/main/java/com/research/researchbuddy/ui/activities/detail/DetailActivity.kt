package com.research.researchbuddy.ui.activities.detail

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.research.researchbuddy.R

class DetailActivity: AppCompatActivity() {

    private lateinit var title: String
    private lateinit var year: String
    private lateinit var author: String
    private lateinit var abstract: String

    private lateinit var titleView: TextView
    private lateinit var yearView: TextView
    private lateinit var authorView: TextView
    private lateinit var abstractView: TextView

    companion object {
        const val DETAIL_TITLE = "extra_title"
        const val DETAIL_YEAR = "extra_year"
        const val DETAIL_AUTHOR = "extra_author"
        const val DETAIL_ABSTRACT = "extra-abstract"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        title = intent.getStringExtra(DETAIL_TITLE).toString()
        year = intent.getStringExtra(DETAIL_YEAR).toString()
        author = intent.getStringExtra(DETAIL_AUTHOR).toString()
        abstract = intent.getStringExtra(DETAIL_ABSTRACT).toString()

        titleView = findViewById(R.id.title)
        yearView = findViewById(R.id.year)
        authorView = findViewById(R.id.author)
        abstractView = findViewById(R.id.abstract_text)

        titleView.text = title
        yearView.text = year
        authorView.text = author
        abstractView.text = abstract
    }

}