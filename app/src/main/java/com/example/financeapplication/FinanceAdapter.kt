package com.example.financeapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FinanceAdapter(private val data: List<Triple<String, String, String>>):
    RecyclerView.Adapter<FinanceAdapter.FinanceViewHolder>(){



    class FinanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.findViewById(R.id.textView1)
        val textView2: TextView = itemView.findViewById(R.id.textView2)
        val textView3: TextView = itemView.findViewById(R.id.textView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.history_list_item_layout, parent, false)
        return FinanceViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: FinanceViewHolder, position: Int) {
        val currentItem = data[position]
        holder.textView1.text = currentItem.first
        holder.textView2.text = currentItem.second
        holder.textView3.text = currentItem.third
    }

    override fun getItemCount(): Int {
        return data.size

    }

}