package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_new.*
import kotlinx.android.synthetic.main.activity_main.et_idNumber as et_idNumber
import kotlinx.android.synthetic.main.activity_main.et_phone as et_phone1
import kotlinx.android.synthetic.main.activity_new.et_url as et_url1

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        //intent 받기
        val intent_new = getIntent()

        //
        var name = intent_new.getStringExtra("name")
        var department = intent_new.getStringExtra("department")
        var idNumber = intent_new.getStringExtra("idNumber")

        //Toast 메시지
        Toast.makeText(this,
            "Student info : " + name + ", " + department + ", " + idNumber,
            Toast.LENGTH_SHORT).show()

        //돌아가기 버튼 눌렀을 때
        btn_return.setOnClickListener {

            var url = et_url.text.toString()
            var phone = et_phone.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("url",url)
            intent.putExtra("phone",phone)
            setResult(RESULT_OK, intent)
            finish()  //자기 자신 액티비티를 파괴한다.
        }
    }
}