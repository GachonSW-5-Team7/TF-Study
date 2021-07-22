package com.example.assignment3_kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v =  inflater.inflate(R.layout.fragment_main, null)
        val items = mutableListOf<ListViewItem>()

        items.add(ListViewItem("Monday"))
        items.add(ListViewItem("Tuesday"))
        items.add(ListViewItem("Wednesday"))
        items.add(ListViewItem("Thursday"))
        items.add(ListViewItem("Friday"))

        val adapter = ListViewAdapter(items)

        val listView: ListView = v.findViewById(R.id.listview)
        listView.adapter = adapter


        listView.setOnItemClickListener {parent: AdapterView<*>, view: View, position: Int, id: Long ->
            val item = listView.selectedItem.toString()
            val duration = Toast.LENGTH_SHORT
            Toast.makeText(context, item, duration).show()}

        return v
    }
}
