package com.example.rickandmorty.presentation.ui.character

import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.domain.usecase.CharacterUseCase
import com.example.rickandmorty.presentation.ui.base.BaseViewModel
import kg.example.mangalib.domain.utils.UiState
import kotlinx.coroutines.flow.*

class CharacterViewModel(
    private val characterUseCase: CharacterUseCase
    ) : BaseViewModel(){
    private val _getAllManga = MutableStateFlow<UiState<List<CharacterModel>>>(UiState.Empty())
    val getAllManga = _getAllManga.asStateFlow()

    fun getCharacter(){
        characterUseCase.getCharacter().collectFlow(_getAllManga)
        }

}