package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //액티비티가 최초 실행 되면 이곳을 수행한다.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        * var :  변수 값이 언제든지 변경 될 수 있음
        * val :  자바에서는 final 값이 변경되지 못하는 변수.
        */

        btn_login.setOnClickListener{ //에딧 텍스트에 입력되어있는 값을 가지고 와서 텍스트뷰에 뿌려준다.
            var et_name = et_name.text.toString()
            var et_department = et_department.text.toString()
            var et_idNumber = et_idNumber.text.toString()

            val intent = Intent(this, NewActivity::class.java)
            intent.putExtra("name",et_name)
            intent.putExtra("department",et_department)
            intent.putExtra("idNumber",et_idNumber)

            startActivityForResult(intent,1) //intent에 저장되어있는 액티비티 쪽으로 이동한다.
        }

        btn_url.setOnClickListener{
            var url = et_url.text.toString()
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://"+url))
            startActivity(intent)
        }

        btn_phone.setOnClickListener{
            var phone = et_phone.text.toString()
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+phone))
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var url = data?.getStringExtra("url")
        var phone = data?.getStringExtra("phone")
        et_url.setText(url)
        et_phone.setText(phone)

    }
}