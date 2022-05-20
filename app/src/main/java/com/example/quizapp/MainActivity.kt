package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        btn_start.setOnClickListener { 
            if (et1.text.toString().isEmpty()){
                Toast.makeText(this, "Baby please name lekha", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,Quiz_question::class.java)
                startActivity(intent)
                finish()
            }
        }



    }
}