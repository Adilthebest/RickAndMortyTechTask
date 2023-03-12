package com.example.rickandmorty.presentation.ui.fragment.episode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rickandmorty.databinding.ItemEpisodeBinding
import com.example.rickandmorty.domain.model.modelEpisode.Episode

class EpisodeAdapter :
    PagingDataAdapter<Episode, EpisodeAdapter.EpisodeViewHolder>(LocationModelItemCallback) {
    class EpisodeViewHolder(private val binding: ItemEpisodeBinding) : ViewHolder(binding.root) {
        fun bind(episode: com.example.rickandmorty.domain.model.modelEpisode.Episode) = with(binding) {
            episode.apply {
                tvNumber.text = id.toString()
                tvName.text = name
                tvEpisode.text = episode.episode
                tvAirData.text = air_date
            }
        }
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            ItemEpisodeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private object LocationModelItemCallback : DiffUtil.ItemCallback<com.example.rickandmorty.domain.model.modelEpisode.Episode>() {
        override fun areItemsTheSame(oldItem: com.example.rickandmorty.domain.model.modelEpisode.Episode, newItem: com.example.rickandmorty.domain.model.modelEpisode.Episode): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: com.example.rickandmorty.domain.model.modelEpisode.Episode, newItem: com.example.rickandmorty.domain.model.modelEpisode.Episode): Boolean {
            return oldItem.id == newItem.id && oldItem.name == newItem.name
        }
    }
}