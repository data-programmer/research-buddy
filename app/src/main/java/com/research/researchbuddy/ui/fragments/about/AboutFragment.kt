package com.research.researchbuddy.ui.fragments.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.research.researchbuddy.R

class AboutFragment : Fragment() {

    private lateinit var downloadsViewModel: AboutViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        downloadsViewModel =
//            ViewModelProvider(this).get(AboutViewModel::class.java)
//        val textView: TextView = root.findViewById(R.id.text_downloads)
//        downloadsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

}