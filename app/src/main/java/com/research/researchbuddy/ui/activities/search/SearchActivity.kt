package com.research.researchbuddy.ui.activities.search

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.research.researchbuddy.R
import com.research.researchbuddy.ui.activities.detail.DetailActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

class SearchActivity: AppCompatActivity(), SearchClickListener, KodeinAware {

    override val kodein by closestKodein()
    //private val viewModelFactory: SearchViewModelFactory by instance()
    private lateinit var viewModel: SearchViewModel
    private lateinit var searchAdapter: SearchAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var emptyLayout: LinearLayout

    companion object {
        const val EXTRA_SEARCH_PROVIDER = "extra_search_provider"
        const val EXTRA_SEARCH_BY = "extra_search_by"
        const val EXTRA_SEARCH_TEXT = "extra_search_text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setAdapter()

        emptyLayout = findViewById(R.id.empty_layout)
        progressBar = findViewById(R.id.progress_bar)

        viewModel = ViewModelProvider(
                this,
                SearchViewModelFactory(this)
        ).get(SearchViewModel::class.java)

        viewModel.searchProvider = intent.getStringExtra(EXTRA_SEARCH_PROVIDER).toString()
        viewModel.searchBy = intent.getStringExtra(EXTRA_SEARCH_BY).toString()
        viewModel.searchText = intent.getStringExtra(EXTRA_SEARCH_TEXT).toString()

        viewModel.researchSearchResult.observe(this, Observer {
            val data = it ?: return@Observer
            if (!data.isNullOrEmpty()) {
                searchAdapter.setItems(data)
                recyclerView.visibility = View.VISIBLE
            } else {
                emptyLayout.visibility = View.VISIBLE
                Toast.makeText(
                        this,
                        "Failed to retrieve search results",
                        Toast.LENGTH_LONG
                ).show()
            }
            progressBar.visibility = View.GONE
        })

        viewModel.fetchResearchSearchResult()
    }

    override fun onSearchItemClick(
        title: String,
        year: String,
        author: String,
        abstract: String
    ) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.DETAIL_TITLE, title)
        intent.putExtra(DetailActivity.DETAIL_YEAR, year)
        intent.putExtra(DetailActivity.DETAIL_AUTHOR, author)
        intent.putExtra(DetailActivity.DETAIL_ABSTRACT, abstract)

        startActivity(intent)
    }

    private fun setAdapter() {
        searchAdapter = SearchAdapter(this)
        recyclerView = findViewById(R.id.search_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = searchAdapter
    }

}