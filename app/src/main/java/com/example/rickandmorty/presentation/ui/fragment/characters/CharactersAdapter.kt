package com.example.rickandmorty.presentation.ui.fragment.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.ItemCharactersBinding
import com.example.rickandmorty.domain.model.modelCharacters.Result

class CharactersAdapter : androidx.paging.PagingDataAdapter<Result, CharactersAdapter.CharactersViewHolder>(CharacterModelItemCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            ItemCharactersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class CharactersViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Result) = with(binding) {
            result.apply {
                imageCharacter.load(image)
                nameCharacter.text = name
                when (status) {
                     "Alive" -> imageStatus.setImageResource(R.drawable.ic_alive_status)
                    "Dead" -> imageStatus.setImageResource(R.drawable.ic_dead_status)
                    "unknown" -> imageStatus.setImageResource(R.drawable.ic_unknown_status)
                }
                statusCharacter.text =
                    statusCharacter.context.getString(
                        R.string.character_status,
                        status,
                        species
                    )
                tvLocation.text = location.name
                tvCreate.text = created

            }
        }
    }

    private object CharacterModelItemCallback : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id && oldItem.image == newItem.image
        }
    }
}