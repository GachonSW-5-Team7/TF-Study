package com.example.assignment3_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment3_kotlin.databinding.ActivityMainBinding

//ViewBinding = Layout 에 있는 View의 Id를 코틀린 코드에서 직접 사용 할 수 있게 해주는 도구

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)
        binding.btnMain.setOnClickListener {
            setFragment_Main()
        }
        binding.btnMenu.setOnClickListener {
            setFragment_Menu()
        }
    }
    private fun setFragment_Main() {
        val transaction = supportFragmentManager.beginTransaction()
            .add(R.id.container, MainFragment())
        transaction.commit()
    }

    private fun setFragment_Menu() {
        val transaction = supportFragmentManager.beginTransaction()
            .add(R.id.container, MenuFragment())
        transaction.commit()
    }
}
