package com.example.rickandmorty.presentation.ui.fragment.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rickandmorty.databinding.ItemLocationBinding
import com.example.rickandmorty.domain.model.modelLocation.Location

class LocationAdapter :
    PagingDataAdapter<Location, LocationAdapter.LocationViewHolder>(LocationModelItemCallback) {
    class LocationViewHolder(private val binding: ItemLocationBinding) : ViewHolder(binding.root) {
        fun bind(location: Location) = with(binding) {
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

    private object LocationModelItemCallback : DiffUtil.ItemCallback<Location>() {
        override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem.id == newItem.id && oldItem.name == newItem.name
        }
    }
}