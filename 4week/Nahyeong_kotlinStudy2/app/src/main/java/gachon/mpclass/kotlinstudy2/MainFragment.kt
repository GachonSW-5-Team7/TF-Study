package gachon.mpclass.kotlinstudy2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false) as ViewGroup
        val menuButton = rootView.findViewById<View>(R.id.menuButton) as Button

        menuButton.setOnClickListener {
            val activity = activity as MainActivity?
            activity!!.onFragmentChanged(0)
        }

        val days = arrayOf(
            getString(R.string.mon),
            getString(R.string.tue),
            getString(R.string.wed),
            getString(R.string.thu),
            getString(R.string.fri)
        )

        val dayList = rootView.findViewById<View>(R.id.listview) as ListView
        val adapter = ArrayAdapter(activity as MainActivity, android.R.layout.simple_list_item_1, days)

        dayList.adapter = adapter
        dayList.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            Toast.makeText(context, days[position], Toast.LENGTH_SHORT).show()
        }

        return rootView
    }
}
