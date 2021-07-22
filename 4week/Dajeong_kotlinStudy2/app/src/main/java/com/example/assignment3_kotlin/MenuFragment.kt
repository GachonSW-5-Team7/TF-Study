package com.example.assignment3_kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v =  inflater.inflate(R.layout.fragment_menu, null)

        val spinner: Spinner = v.findViewById(R.id.spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.array_subjects,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                spinner.adapter = adapter

                //스피너 초기 값을 모바일 프로그래밍으로 정하기
                spinner.setSelection(1);

                spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        val txt_planet = spinner.selectedItem.toString()
                        val duration = Toast.LENGTH_SHORT

                        val toast = Toast.makeText(context, txt_planet+"(이)가 선택되었습니다.", duration)
                        toast.show()

                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) { } }
            }
        }
        return v
    }
}
