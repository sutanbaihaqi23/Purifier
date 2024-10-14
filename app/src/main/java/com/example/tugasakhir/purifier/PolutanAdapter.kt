package com.example.tugasakhir.purifier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class PolutanItem(val name: String, val value: Double)

class PolutanAdapter(private val dataList: List<PolutanItem>) : RecyclerView.Adapter<PolutanAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvPolutan: TextView = view.findViewById(R.id.tv_polutan)
        val indexPolutan: TextView = view.findViewById(R.id.index_polutan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.tvPolutan.text = item.name
        holder.indexPolutan.text = item.value.toString()
    }

    override fun getItemCount() = dataList.size
}