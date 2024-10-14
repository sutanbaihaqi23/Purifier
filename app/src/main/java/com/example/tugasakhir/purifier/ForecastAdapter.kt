package com.example.tugasakhir.purifier

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ForecastAdapter(private val items: List<ForecastItem>) :
    RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    private var selectedPosition = RecyclerView.NO_POSITION

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val llForecastItem: LinearLayout = view.findViewById(R.id.llForecastItem)
        val tvTemperatureRange: TextView = view.findViewById(R.id.tvTemperatureRange)
        val ivWeatherIcon: ImageView = view.findViewById(R.id.ivWeatherIcon)
        val tvTemperature: TextView = view.findViewById(R.id.tvTemperature)
        val ivWindIcon: ImageView = view.findViewById(R.id.ivWindIcon)
        val tvWindSpeed: TextView = view.findViewById(R.id.tvWindSpeed)
        val tvTime: TextView = view.findViewById(R.id.tvTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvTemperatureRange.text = item.temperatureRange
        holder.ivWeatherIcon.setImageResource(item.weatherIcon)
        holder.tvTemperature.text = "${item.temperature}°"
        holder.ivWindIcon.setImageResource(item.windicon)
        holder.tvWindSpeed.text = "${item.windSpeed} km/h"
        holder.tvTime.text = item.time

        // Set selected state
        holder.llForecastItem.isSelected = position == selectedPosition

        // Set click listener
        holder.itemView.setOnClickListener {
            setSelectedPosition(position)
        }
    }

    override fun getItemCount() = items.size

    private fun setSelectedPosition(position: Int) {
        val previousSelected = selectedPosition
        selectedPosition = position
        notifyItemChanged(previousSelected)
        notifyItemChanged(selectedPosition)
    }
}