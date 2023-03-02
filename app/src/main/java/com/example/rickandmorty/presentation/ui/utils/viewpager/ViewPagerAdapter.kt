package com.example.rickandmorty.presentation.ui.utils.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.rickandmorty.presentation.ui.fragment.characters.CharactersFragment
import com.example.rickandmorty.presentation.ui.fragment.episode.EpisodeFragment
import com.example.rickandmorty.presentation.ui.fragment.location.LocationFragment


class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val count = 3

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CharactersFragment()
            1 -> EpisodeFragment()
            2 -> LocationFragment()
            else -> CharactersFragment()
        }
    }

    override fun getCount(): Int {
        return count
    }

    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> return "Персонажи"
            1 -> return "Эпизод"
            2 -> return "Локации"
        }
        return ""
    }

}
