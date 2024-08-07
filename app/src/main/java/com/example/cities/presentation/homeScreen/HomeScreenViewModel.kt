package com.example.cities.presentation.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cities.data.model.City
import com.example.cities.domain.usecase.SearchCitiesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val searchCitiesUseCase: SearchCitiesUseCase,
) : ViewModel() {
    private val _cities = MutableStateFlow<List<City>>(emptyList())
    val cities: StateFlow<List<City>> get() = _cities

    private val _filterText = MutableStateFlow("")
    val filterText: StateFlow<String> get() = _filterText

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    init {
        viewModelScope.launch {
            filterText.collect { text ->
                searchCitiesUseCase.initialize()
                _cities.value = searchCitiesUseCase.search(text)
            }
        }
    }

    fun onFilterTextChanged(newText: String) {
        _filterText.value = newText
    }
}