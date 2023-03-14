package com.example.rickandmorty.presentation.ui.fragment.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rickandmorty.databinding.ItemLocationBinding
import com.example.rickandmorty.domain.model.modelLocation.Location
import com.example.rickandmorty.presentation.ui.model.LocationUI

class LocationAdapter :
    PagingDataAdapter<LocationUI, LocationAdapter.LocationViewHolder>(LocationModelItemCallback) {
    class LocationViewHolder(private val binding: ItemLocationBinding) : ViewHolder(binding.root) {
        fun bind(location: LocationUI) = with(binding) {
            location.apply {
                tvNumber.text = id.toString()
                tvName.text = name
                tvDimension.text = dimension
                tvType.text = type
            }
        }
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            ItemLocationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private object LocationModelItemCallback : DiffUtil.ItemCallback<LocationUI>() {
        override fun areItemsTheSame(oldItem: LocationUI, newItem: LocationUI): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: LocationUI, newItem: LocationUI): Boolean {
            return oldItem.id == newItem.id && oldItem.name == newItem.name
        }
    }
}