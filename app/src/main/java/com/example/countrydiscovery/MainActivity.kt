package com.example.countrydiscovery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.countrydiscovery.ui.CountryListActivity

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_country_list  = findViewById<Button>(R.id.bt_get_list)

        btn_country_list.setOnClickListener {
            startActivity(Intent(this, CountryListActivity::class.java))
        }
    }
}