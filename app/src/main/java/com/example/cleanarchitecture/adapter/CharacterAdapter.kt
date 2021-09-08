package com.example.cleanarchitecture.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ItemRecyclerViewBinding
import com.example.domain.entity.CharacterData

class CharacterAdapter(private var characters: List<CharacterData>, private val onCharacterListener: OnCharacterListener) :
    RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {

    class CharacterHolder(
        private val binding: ItemRecyclerViewBinding,
        private val context: Context,
        private val onCharacterListener: OnCharacterListener
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(characterData: CharacterData) {
            with(binding) {
                textViewItemRecyclerViewCharacter.text =
                    context.getString(R.string.text_view_character_name_item_recycler_view, characterData.name)
                Glide.with(context)
                    .load("${characterData.thumbnail.path}.${characterData.thumbnail.extension}")
                    .into(imageViewItemRecyclerViewIcon)
            }
        }

        override fun onClick(v: View?) {
            onCharacterListener.onCharacterClick(adapterPosition)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder = CharacterHolder(
        ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        parent.context,
        onCharacterListener
    )

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int = characters.size

    fun getCharacter(position: Int): CharacterData = characters[position]

    fun setCharacters(characters: List<CharacterData>) {
        this.characters = characters
        notifyDataSetChanged()
    }

    interface OnCharacterListener {
        fun onCharacterClick(position: Int)
    }
}
