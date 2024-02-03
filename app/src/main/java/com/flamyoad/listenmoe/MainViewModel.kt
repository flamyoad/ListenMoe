package com.flamyoad.listenmoe

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.flamyoad.listenmoe.com.flamyoad.listenmoe.usecase.SongsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val songsUseCase: SongsUseCase
): ViewModel() {

    suspend fun fetch() = songsUseCase.getSongDetail(11)
}