package com.research.researchbuddy.ui.fragments.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.research.researchbuddy.R
import com.research.researchbuddy.room.entity.FavoriteEntity
import kotlinx.android.synthetic.main.download_item.view.title
import kotlinx.android.synthetic.main.favorite_item.view.*

class FavoritesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: MutableList<FavoriteEntity> = mutableListOf()

    class FavoriteViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favorite_item, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val favorite = list[position]
        holder.itemView.title.text = favorite.title
        holder.itemView.year.text = favorite.year
        holder.itemView.author.text = "Kingsley, William"//favorite.author
    }

    override fun getItemCount(): Int = list.size

    fun setItems(list: List<FavoriteEntity>) {
        this.list = list as MutableList<FavoriteEntity>
        notifyDataSetChanged()
    }

}