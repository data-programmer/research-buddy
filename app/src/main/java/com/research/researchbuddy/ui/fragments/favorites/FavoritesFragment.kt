package com.research.researchbuddy.ui.fragments.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.research.researchbuddy.R

class FavoritesFragment : Fragment() {

    private lateinit var favoritesViewModel: FavoritesViewModel
    private lateinit var favoritesAdapter: FavoritesAdapter
    private lateinit var emptyLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        favoritesViewModel = ViewModelProvider(
            this,
            FavoritesViewModelFactory(requireContext())
        ).get(FavoritesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAdapter(view)

        emptyLayout = view.findViewById(R.id.empty_layout)

        favoritesViewModel.favorites.observe(viewLifecycleOwner, Observer {
            val data = it ?: return@Observer
            if (!data.isNullOrEmpty()) {
                favoritesAdapter.setItems(data)
                emptyLayout.visibility = View.GONE
            } else {
                emptyLayout.visibility = View.VISIBLE
            }
        })
    }

    private fun setAdapter(view: View) {
        favoritesAdapter = FavoritesAdapter()
        val favoritesRecyclerView = view.findViewById<RecyclerView>(R.id.favorite_recycler_view)
        favoritesRecyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        favoritesRecyclerView.adapter = favoritesAdapter
    }

}