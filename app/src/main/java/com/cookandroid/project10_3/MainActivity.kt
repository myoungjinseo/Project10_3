package com.cookandroid.project10_3

import android.app.Activity
import android.content.Intent
import android.icu.number.Precision
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "메인 엑티비티"
        var edtNum1 = findViewById<EditText>(R.id.edtNum1)
        var edtNum2 = findViewById<EditText>(R.id.edtNum2)
        var rgbGroup = findViewById<RadioGroup>(R.id.rgbGroup)
        var btnNewActivity = findViewById<Button>(R.id.btnNewActivity)
        btnNewActivity.setOnClickListener {
            var intent = Intent(applicationContext, Second::class.java)

                when (rgbGroup.checkedRadioButtonId) {
                    R.id.rdoAdd -> {
                        intent.putExtra("Calc", "+")
                    }

                    R.id.rdoSub -> {
                        intent.putExtra("Calc", "-")
                    }

                    R.id.rdoMul -> {
                        intent.putExtra("Calc", "*")
                    }

                    R.id.rdoDiv -> {
                        intent.putExtra("Calc", "/")
                    }
                }
                intent.putExtra("Num1", Integer.parseInt(edtNum1.text.toString()))
                intent.putExtra("Num2", Integer.parseInt(edtNum2.text.toString()))
                startActivityForResult(intent,0)

        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            var hap = data!!.getIntExtra("Hap",0)
            Toast.makeText(applicationContext,"결과 : $hap",Toast.LENGTH_SHORT).show()
        }
    }

}