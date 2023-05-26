package com.example.flagasean.repository

import com.dariwan.flagcountryasean.model.CountryData
import com.example.flagasean.model.Country

class CountryRepository {
    fun getCountryData(): List<Country> = CountryData.country

    fun getCountryId(id: String): Country = CountryData.country.find {
        it.id == id
    } as Country
}