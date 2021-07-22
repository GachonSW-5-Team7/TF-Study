package gachon.mpclass.kotlinstudy2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_menu, container, false) as ViewGroup
        val mainButton = rootView.findViewById<View>(R.id.mainButton) as Button

        mainButton.setOnClickListener {
            val activity = activity as MainActivity?
            activity!!.onFragmentChanged(1)
        }

        val objects = arrayOf(
            getString(R.string.ds),
            getString(R.string.mp),
            getString(R.string.se),
            getString(R.string.ba),
            getString(R.string.ss),
            getString(R.string.gp)
        )

        val spinner = rootView.findViewById<View>(R.id.spinner) as Spinner
        val adapter =
            ArrayAdapter(activity as MainActivity, android.R.layout.simple_spinner_item, objects)

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    context,
                    objects[position] + getString(R.string.announce),
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        return rootView
    }
}