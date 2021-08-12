package com.example.dajeong_kotlinstudy3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new.*
import java.util.ArrayList

class NewActivity : Activity() {

    var timeLapsList : ArrayList<TimeLaps> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        //intent 받기
        val intent_new = getIntent()
        timeLapsList = intent_new.getSerializableExtra("list") as ArrayList<TimeLaps>

        val adapter = TimeLapsListAdapter(timeLapsList)
//        adapter.setItemClickListener(object : TimeLapsListAdapter.OnItemClickListener{
//            override fun onClick(v: View, position: Int) {
//                val item = timeLapsList[position]
//
//                //Toast.makeText(v.context, "Activity\n${item.timeLap}", Toast.LENGTH_SHORT).show()
//                //item.timeLap = item.timeLap + "1"
//                adapter.notifyDataSetChanged()
//            }
//        })
        mRecyclerView.adapter = adapter

        //돌아가기 버튼 눌렀을 때
        btn_return.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            setResult(RESULT_OK, intent)
            finish()  //자기 자신 액티비티를 파괴한다.
        }
    }
}