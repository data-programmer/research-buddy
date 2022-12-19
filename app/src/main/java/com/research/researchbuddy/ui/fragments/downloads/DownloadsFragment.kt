package com.research.researchbuddy.ui.fragments.downloads

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

class DownloadsFragment : Fragment() {

    private lateinit var downloadsViewModel: DownloadsViewModel
    private lateinit var downloadAdapter: DownloadAdapter
    private lateinit var emptyLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        downloadsViewModel = ViewModelProvider(
            this,
            DownloadViewModelFactory(requireContext())
        ).get(DownloadsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_downloads, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAdapter(view)

        emptyLayout = view.findViewById(R.id.empty_layout)

        downloadsViewModel.downloads.observe(viewLifecycleOwner, Observer {
            val data = it ?: return@Observer
            if (!data.isNullOrEmpty()) {
                downloadAdapter.setItems(data)
                emptyLayout.visibility = View.GONE
            } else {
                emptyLayout.visibility = View.VISIBLE
            }
        })
    }

    private fun setAdapter(view: View) {
        downloadAdapter = DownloadAdapter()
        val downloadRecyclerView = view.findViewById<RecyclerView>(R.id.download_recycler_view)
        downloadRecyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        downloadRecyclerView.adapter = downloadAdapter
    }

}