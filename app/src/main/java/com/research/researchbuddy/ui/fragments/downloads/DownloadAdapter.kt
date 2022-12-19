package com.research.researchbuddy.ui.fragments.downloads

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.research.researchbuddy.R
import com.research.researchbuddy.room.entity.DownloadEntity
import kotlinx.android.synthetic.main.download_item.view.*

class DownloadAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: MutableList<DownloadEntity> = mutableListOf()

    class DownloadViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.download_item, parent, false)
        return DownloadViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val download = list[position]
        holder.itemView.title.text = download.title
    }

    override fun getItemCount(): Int = list.size

    fun setItems(list: List<DownloadEntity>) {
        this.list = list as MutableList<DownloadEntity>
        notifyDataSetChanged()
    }

}