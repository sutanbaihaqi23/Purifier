package com.example.tugasakhir.purifier

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasakhir.purifier.databinding.ActivityMainBinding
import com.example.tugasakhir.purifier.databinding.DialogRecycleviewBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rvForecast: RecyclerView = findViewById(R.id.rvForecast)
        val forecastItems = listOf(
            ForecastItem("0-50", R.drawable.sun, R.drawable.wind, 27, "1.2km/h", "10.00"),
            ForecastItem("0-50", R.drawable.sun,  R.drawable.wind, 27,"1.2km/h", "11.00"),
            ForecastItem("0-50", R.drawable.sun,  R.drawable.wind, 27,"1.2km/h", "12.00"),
            ForecastItem("0-50", R.drawable.sun,  R.drawable.wind, 27,"1.2km/h", "13.00"),
            ForecastItem("0-50", R.drawable.sun,  R.drawable.wind, 27,"1.2km/h", "14.00")
        )

        binding.iconInfo.setOnClickListener {

        }


        val adapter = ForecastAdapter(forecastItems)
        rvForecast.adapter = adapter
        rvForecast.scrollToPosition(1)

        val rvPolutan: RecyclerView=findViewById(R.id.rvPolutan)
        rvPolutan.layoutManager=GridLayoutManager(this,2)
        val dataList = listOf(
            PolutanItem("PM 2.5", 26.8),
            PolutanItem("PM 10", 30.2),
            PolutanItem("NO2", 18.0),
            PolutanItem("O3", 22.1)
        )
        rvPolutan.adapter=PolutanAdapter(dataList)
    }
}