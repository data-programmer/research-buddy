package com.research.researchbuddy.ui.activities.search

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.research.researchbuddy.R

class SearchViewHolder(
    view: View,
    private val onClickListener: OnViewHolderClickListener
    ): RecyclerView.ViewHolder(view), View.OnClickListener {

    val title: TextView = itemView.findViewById(R.id.title)

    val year: TextView = itemView.findViewById(R.id.year)

    val author: TextView = itemView.findViewById(R.id.author)

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        onClickListener.onClick(adapterPosition)
    }

}