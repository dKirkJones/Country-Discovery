package com.example.countrydiscovery.repository

import com.example.countrydiscovery.data.Country
import com.example.countrydiscovery.network.NetworkLayer
import com.example.countrydiscovery.network.safeApiCall
import com.example.countrydiscovery.utils.SimpleResponse

class SharedRepository  {

    suspend fun getCountryFromApi() : SimpleResponse<List<Country.CountryItem>> {
        return safeApiCall { NetworkLayer.api.getDataFromAPI() }
    }
}