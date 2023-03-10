package com.example.rickandmorty.presentation.ui.fragment.episode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rickandmorty.databinding.ItemEpisodeBinding
import com.example.rickandmorty.domain.model.modelEpisode.Episode
import com.example.rickandmorty.presentation.ui.model.EpisodeUi

class EpisodeAdapter :
    PagingDataAdapter<EpisodeUi, EpisodeAdapter.EpisodeViewHolder>(LocationModelItemCallback) {
    class EpisodeViewHolder(private val binding: ItemEpisodeBinding) : ViewHolder(binding.root) {
        fun bind(episode: EpisodeUi) = with(binding) {
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

    private object LocationModelItemCallback : DiffUtil.ItemCallback<EpisodeUi>() {
        override fun areItemsTheSame(oldItem: EpisodeUi, newItem: EpisodeUi): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: EpisodeUi, newItem: EpisodeUi): Boolean {
            return oldItem.id == newItem.id && oldItem.name == newItem.name
        }
    }
}