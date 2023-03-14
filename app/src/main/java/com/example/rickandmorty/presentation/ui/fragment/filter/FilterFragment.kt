package com.example.rickandmorty.presentation.ui.fragment.filter

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentFiltrBinding
import com.example.rickandmorty.presentation.ui.base.BaseAlertFilter
import com.example.rickandmorty.presentation.ui.fragment.characters.AllViewModel
import com.example.rickandmorty.domain.model.modelCharacters.CharacterFilter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FilterFragment : BaseAlertFilter<FragmentFiltrBinding>(R.layout.fragment_filtr) {
    private var currentFilter = CharacterFilter()
    private val viewModel: AllViewModel by sharedViewModel()
    override val binding by viewBinding<FragmentFiltrBinding>()

    override fun getCheckedFilter() {
        getCheckedStatus()?.let { binding.rgStatus.check(it) }
        getCheckedSpecies()?.let { binding.rgSpecies.check(it) }
        getCheckedGender()?.let { binding.rgGender.check(it) }
    }

    override fun initView() = with(binding) {
        btnFiltr.setOnClickListener {
            currentFilter.apply {
                viewModel.filter(status, species, gender)
            }
        }
        btnClear.setOnClickListener {
            rgGender.clearCheck()
            rgStatus.clearCheck()
            rgSpecies.clearCheck()
            currentFilter.gender = null
            currentFilter.status = null
            currentFilter.species = null
        }
    }

    override fun filterCheckId() {
        requireDialog().setCancelable(true)
        requireDialog().setCanceledOnTouchOutside(true)
        binding.rgStatus.setOnCheckedChangeListener { group, checkedId ->
            currentFilter.status = when (checkedId) {
                R.id.status_alive -> "alive"
                R.id.status_dead -> "dead"
                R.id.status_unknown -> "unknown"
                else -> null
            }
        }

        binding.rgSpecies.setOnCheckedChangeListener { group, checkedId ->
            currentFilter.species = when (checkedId) {
                R.id.species_alien -> "alien"
                R.id.species_human -> "Human"
                R.id.species_humanoid -> "Humanoid"
                else -> null
            }
        }

        binding.rgGender.setOnCheckedChangeListener { group, checkedId ->
            currentFilter.gender = when (checkedId) {
                R.id.gender_male -> "Male"
                R.id.gender_female -> "Female"
                R.id.gender_unknown -> "unknown"
                else -> null
            }
        }
    }

    private fun getCheckedSpecies(): Int? {
        return when (currentFilter.species) {
            "alien" -> R.id.species_alien
            "Human" -> R.id.species_human
            "humanoid" -> R.id.species_humanoid
            else -> null
        }
    }

    private fun getCheckedStatus(): Int? {
        return when (currentFilter.status) {
            "alive" -> R.id.status_alive
            "dead" -> R.id.status_dead
            "unknown" -> R.id.status_unknown
            else -> null
        }
    }

    private fun getCheckedGender(): Int? {
        return when (currentFilter.gender) {
            "Male" -> R.id.gender_male
            "Female" -> R.id.gender_female
            "unknown" -> R.id.gender_unknown
            else -> null
        }
    }
}