package com.example.countrydiscovery.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countrydiscovery.R
import com.example.countrydiscovery.adapter.CountryListAdapter
import com.example.countrydiscovery.data.Country
import com.example.countrydiscovery.viewmodel.CountryViewModel

class CountryListActivity : AppCompatActivity(), CountryListAdapter.OnItemClickListener {

    val TAG = "CountryListActivity"

    lateinit var myAdapter: CountryListAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerViewCountries: RecyclerView

    private val viewModel: CountryViewModel by viewModels()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recyclerViewCountries = findViewById(R.id.country_recycler_view)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerViewCountries.layoutManager = linearLayoutManager
        myAdapter = CountryListAdapter(emptyList(), this)
        recyclerViewCountries.adapter = myAdapter

        viewModel.countriesLiveData.observe(this) {
            myAdapter.countryList = it
            myAdapter.notifyDataSetChanged()
        }

        viewModel.exceptionLiveData.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.getCountries()
    }

    override fun onItemClick(position: Country.CountryItem) {
       val intent = Intent(this@CountryListActivity, CountryDetailsActivity::class.java)
        startActivity(intent)
    }

}
