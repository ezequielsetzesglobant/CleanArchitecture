package com.example.cleanarchitecture.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ItemRecyclerViewBinding
import com.example.domain.entity.CharacterData

class CharacterAdapter(private val characters: List<CharacterData>) : RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {

    class CharacterHolder(private val binding: ItemRecyclerViewBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(characterData: CharacterData) {
            with(binding) {
                textViewItemRecyclerViewDay.text =
                    context.getString(R.string.text_view_character_name_item_recycler_view, characterData.name)
                Glide.with(context)
                    .load("${characterData.thumbnail.path}.${characterData.thumbnail.extension}")
                    .into(imageViewItemRecyclerViewIcon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder =
        CharacterHolder(ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false), parent.context)

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int = characters.size
}
