package com.nikasov.musiclyrics.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikasov.common.utils.DataState
import com.nikasov.data.repository.MusixmatchRepository
import com.nikasov.domain.entity.Track
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val musixmatchRepository: MusixmatchRepository
): ViewModel() {

    private val _list = MutableStateFlow<List<Track>>(emptyList())
    val list = _list.asStateFlow()

    fun getCharts(searchText: String) {
        viewModelScope.launch {
            when(val result = musixmatchRepository.search(searchText)) {
                is DataState.Error -> TODO()
                is DataState.Success -> _list.emit(result.data ?: emptyList())
            }
        }
    }

}