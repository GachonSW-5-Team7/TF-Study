package gachon.mpclass.kotlinstudy2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var mainFragment: MainFragment? = null
    var menuFragment: MenuFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainFragment = MainFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, mainFragment!!).commit()
        menuFragment = MenuFragment()

    }

    fun onFragmentChanged(index: Int) {
        if (index == 0) {
            supportFragmentManager.beginTransaction().replace(R.id.container, menuFragment!!).commit()
        } else if (index == 1) {
            supportFragmentManager.beginTransaction().replace(R.id.container, mainFragment!!).commit()
        }
    }
}