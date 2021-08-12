package com.example.dajeong_kotlinstudy3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var time = 0
    private var isRunning = false
    private var timerTask: Timer? = null

    //텍스트에 두 자리 숫자를 표시하기
    val f: NumberFormat = DecimalFormat("00")

    //시간 기록
    var timeLaps : ArrayList<TimeLaps> = ArrayList()


    //listOf는 읽기 전용
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //버튼 클릭 리스너
        btn_start.setOnClickListener {
            isRunning = !isRunning
            if (isRunning) start() else pause()
        }

        btn_pause.setOnClickListener {
            isRunning = !isRunning
            if (isRunning) {
                start()
                btn_pause.text = "일시정지"
            } else {
                btn_pause.text = "다시시작"
                pause()
            }
        }

        btn_stop.setOnClickListener {
            reset()
        }

        btn_record.setOnClickListener {
            if(time!=0) lapTime()
        }

        btn_showMore.setOnClickListener {

            val intent = Intent(this, NewActivity::class.java)
            intent.putExtra("list", timeLaps)
            startActivity(intent)
        }
    }

    private fun start() {

        //visibility state
        btn_start.visibility = View.INVISIBLE
        btn_pause.visibility = View.VISIBLE
        btn_stop.visibility = View.VISIBLE
        btn_record.visibility = View.VISIBLE
        btn_showMore.visibility = View.VISIBLE

        timerTask = kotlin.concurrent.timer(period = 10) { //반복주기는 peroid 프로퍼티로 설정, 단위는 1000분의 1초 (period = 1000, 1초)
            time++ // period=10으로 0.01초마다 time를 1씩 증가하게 됩니다
            var sec = time / 100// time/100, 나눗셈의 몫 (초 부분)
            var milli = time % 100 // time%100, 나눗셈의 나머지 (밀리초 부분)
            var min = sec / 60
            var hour = min / 60

            sec = sec % 60

            // UI 조작을 위한 메서드
            runOnUiThread {
                txt_timer.text = "${f.format(hour)}:${f.format(min)}:${f.format(sec)}:${f.format(milli)}"
            }
        }
    }

    private fun pause() {
        timerTask?.cancel();
    }

    private fun reset() {

        //visibility state
        btn_start.visibility = View.VISIBLE
        btn_pause.visibility = View.INVISIBLE
        btn_stop.visibility = View.INVISIBLE
        btn_record.visibility = View.INVISIBLE
        btn_showMore.visibility = View.INVISIBLE

        time = 0 // 시간저장 변수 초기화
        isRunning = false // 현재 진행중인지 판별하기 위한 Boolean변수 false 세팅

        txt_timer.text = "00:00:00:00" // 시간 초기화

        //리스트 초기화하는 코드 추가
        timeLaps.clear()

        timerTask?.cancel() // timerTask가 null이 아니라면 cancel() 호출
    }

    private fun lapTime() {
        val lapTime = time // 함수 호출 시 시간(time) 저장

        var sec = lapTime / 100 // time/100, 나눗셈의 몫 (초 부분)
        var milli = lapTime % 100 // time%100, 나눗셈의 나머지 (밀리초 부분)
        var min = sec / 60
        var hour = min / 60

        sec /= 60

        //리스트에 시간 기록하기
        timeLaps.add(TimeLaps("${f.format(hour)}:${f.format(min)}:${f.format(sec)}:${f.format(milli)}"))

    }
}