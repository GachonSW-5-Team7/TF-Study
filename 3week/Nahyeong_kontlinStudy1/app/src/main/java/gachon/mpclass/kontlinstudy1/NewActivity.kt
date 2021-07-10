package gachon.mpclass.kontlinstudy1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_new.*

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val newIntent = getIntent()
        if (newIntent != null) {
            var name = newIntent.getStringExtra("Name")
            var major = newIntent.getStringExtra("Major")
            var id = newIntent.getStringExtra("ID")
            Toast.makeText(
                this,
                "Student info : " + name + ", " + major + ", " + id,
                Toast.LENGTH_SHORT
            ).show()
        }

        goBack.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val bundle = Bundle()
            val url = urlInput.text.toString()
            val phoneNum = phoneNumInput.text.toString()
            bundle.putString("passedURL", url)
            bundle.putString("passedPhone", phoneNum)
            intent.putExtras(bundle)
            setResult(RESULT_OK, intent)
            finish()
        })
    }
}