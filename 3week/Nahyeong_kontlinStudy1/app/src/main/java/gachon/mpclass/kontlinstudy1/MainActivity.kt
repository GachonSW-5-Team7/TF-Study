package gachon.mpclass.kontlinstudy1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Login.setOnClickListener {
            var name = txtUserName.text.toString()
            var major = txtUserMajor.text.toString()
            var id = txtUserID.text.toString()

            if (name.compareTo("") == 0 || major.compareTo("") == 0 || id.compareTo("") == 0) {
                Toast.makeText(
                    applicationContext,
                    "Please fill in all the information.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                var intent = Intent(this, NewActivity::class.java)
                var bundle = Bundle()
                bundle.putString("Name", name)
                bundle.putString("Major", major)
                bundle.putString("ID", id)
                intent.putExtras(bundle)
                startActivityForResult(intent, 1)
            }
        }

        accessWeb.setOnClickListener {
            var parseURL = URL.text.toString()
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://"+parseURL))
            startActivity(intent)
        }

        phoneCall.setOnClickListener {
            var parsePhoneNum = phoneNumber.text.toString()
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+parsePhoneNum))
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var url = data!!.getStringExtra("passedURL")
        var phone = data!!.getStringExtra("passedPhone")
        URL.setText(url)
        phoneNumber.setText(phone)
    }
}