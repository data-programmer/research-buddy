package com.research.researchbuddy.ui.activities.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.research.researchbuddy.R
import com.research.researchbuddy.models.Paper
import kotlinx.android.synthetic.main.search_item.view.*

class SearchAdapter(
    private val searchClickListener: SearchClickListener
    ): RecyclerView.Adapter<RecyclerView.ViewHolder>(), OnViewHolderClickListener {

    private var list: MutableList<Paper> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        return SearchViewHolder(view, this)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]

        holder.itemView.title.text = item.title
        holder.itemView.year.text = item.year
        holder.itemView.author.text = item.authors[0]
    }

    override fun onClick(adapterPosition: Int) {
        val item = list[adapterPosition]
        searchClickListener.onSearchItemClick(
            item.title,
            item.year,
            item.authors[0],
            item.abstract
        )
    }

    override fun getItemCount(): Int = list.size

    fun setItems(list: List<Paper>) {
        this.list = list as MutableList<Paper>
        notifyDataSetChanged()
    }

}