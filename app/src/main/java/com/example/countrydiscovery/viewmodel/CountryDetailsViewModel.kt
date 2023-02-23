package com.example.countrydiscovery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrydiscovery.data.Country

class CountryDetailsViewModel : ViewModel() {

    private val _countryDetail: MutableLiveData<Country.CountryItem> = MutableLiveData()
    val countryDetail: LiveData<Country.CountryItem> = _countryDetail

    fun setCountryDetails(countryItem: Country.CountryItem) {
        _countryDetail.value = countryItem
    }
}