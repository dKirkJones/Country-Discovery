package com.example.countrydiscovery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.example.countrydiscovery.R
import com.example.countrydiscovery.databinding.ActivityCountryDetailsBinding
import com.example.countrydiscovery.viewmodel.CountryDetailsViewModel

class CountryDetailsActivity : AppCompatActivity() {

     private lateinit var binding: ActivityCountryDetailsBinding
    val TAG ="Country Details"

    val _countryViewModel: CountryDetailsViewModel by lazy {
        ViewModelProvider(this)[CountryDetailsViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}