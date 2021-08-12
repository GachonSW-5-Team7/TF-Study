package com.example.dajeong_kotlinstudy3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TimeLapsListAdapter (private val itemList : List<TimeLaps>) : RecyclerView.Adapter<TimeLapsViewHolder>()  {

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeLapsViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_laps, parent, false)
        return TimeLapsViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: TimeLapsViewHolder, position: Int) {
        val item = itemList[position]

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
        holder.apply {
            bind(item)
        }
    }

    //ClickListener
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    private lateinit var itemClickListener : OnItemClickListener

    fun setItemClickListener(itemClickListener: OnItemClickListener) {
        this.itemClickListener = itemClickListener
    }

}