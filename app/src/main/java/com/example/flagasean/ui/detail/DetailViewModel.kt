package com.example.flagasean.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flagasean.model.Country
import com.example.flagasean.repository.CountryRepository
import com.example.flagasean.ui.home.HomeViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel(private val countryRepository: CountryRepository): ViewModel() {
    fun getCountryData(idCountry: String): StateFlow<Country> = MutableStateFlow(
        countryRepository.getCountryId(idCountry)
    ).asStateFlow()

    class ViewModelFactory(private val countryRepository: CountryRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
                return DetailViewModel(countryRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}