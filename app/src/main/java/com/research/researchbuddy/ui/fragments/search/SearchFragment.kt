package com.research.researchbuddy.ui.fragments.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.research.researchbuddy.R
import com.research.researchbuddy.ui.activities.search.SearchActivity

class SearchFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val searchButton = view.findViewById<Button>(R.id.search_button)
        searchButton.setOnClickListener {
            //searchButton.isClickable = false
            submitSearch(view)
        }
    }

    private fun submitSearch(view: View) {
        val searchProvider = view.findViewById<Spinner>(R.id.search_provider).selectedItem.toString()
        val searchBy = view.findViewById<Spinner>(R.id.search_by).selectedItem.toString()
        val searchText = view.findViewById<EditText>(R.id.search_text).text.toString()

        val intent = Intent(requireContext(), SearchActivity::class.java)
        intent.putExtra(SearchActivity.EXTRA_SEARCH_PROVIDER, searchProvider)
        intent.putExtra(SearchActivity.EXTRA_SEARCH_BY, searchBy)
        intent.putExtra(SearchActivity.EXTRA_SEARCH_TEXT, searchText)

        startActivity(intent)
    }

}