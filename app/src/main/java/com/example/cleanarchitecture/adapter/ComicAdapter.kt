package com.example.cleanarchitecture.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ItemRecyclerViewFragmentBinding
import com.example.domain.entity.CharacterData
import com.example.domain.entity.ComicSummaryData

class ComicAdapter(private var comics: List<ComicSummaryData>) :
    RecyclerView.Adapter<ComicAdapter.ComicHolder>() {

    class ComicHolder(private val binding: ItemRecyclerViewFragmentBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comicSummaryData: ComicSummaryData) {
            binding.textViewItemRecyclerViewComic.text =
                context.getString(R.string.text_view_character_name_item_recycler_view, comicSummaryData.name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicHolder = ComicHolder(
        ItemRecyclerViewFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        parent.context
    )

    override fun onBindViewHolder(holder: ComicHolder, position: Int) {
        holder.bind(comics[position])
    }

    override fun getItemCount(): Int = comics.size

    fun setComics(comics: List<ComicSummaryData>) {
        this.comics = comics
        notifyDataSetChanged()
    }
}
