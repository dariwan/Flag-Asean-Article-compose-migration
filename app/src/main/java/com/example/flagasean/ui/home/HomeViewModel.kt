package com.example.flagasean.ui.home

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flagasean.model.Country
import com.example.flagasean.repository.CountryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(countryRepository: CountryRepository): ViewModel() {
    private val _country = MutableStateFlow(countryRepository.getCountryData())
    val country: StateFlow<List<Country>>
    get() = _country.asStateFlow()

    class ViewModelFactory(private val countryRepository: CountryRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)){
                return HomeViewModel(countryRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}