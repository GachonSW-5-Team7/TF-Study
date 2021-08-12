package com.example.dajeong_kotlinstudy3

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_laps.view.*

class TimeLapsViewHolder(v: View) : RecyclerView.ViewHolder(v){
    var view : View = v

    fun bind(item: TimeLaps) {
        view.txt_timeLap.text = item.timeLap
    }
}