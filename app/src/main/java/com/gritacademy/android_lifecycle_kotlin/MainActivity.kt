package com.gritacademy.android_lifecycle_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginBtn = findViewById<Button>(R.id.logoutBtn)


        loginBtn.setOnClickListener(View.OnClickListener {
            val usernameInputElement = findViewById<EditText>(R.id.usernameInput)
            val passwordInputElement = findViewById<EditText>(R.id.passwordInput)
            val enteredUsername = usernameInputElement.text.toString()
            val enteredPassword = passwordInputElement.text.toString()
            if (enteredUsername == "Kalle" && enteredPassword == "Kanel") {
                val a1 = Intent(this@MainActivity, MainActivity::class.java)
                startActivity(a1)
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "wrong username or Password. Correct username is 'Kalle' and correct Password is 'Kanel' ",
                    Toast.LENGTH_LONG
                ).show()

            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_example, menu)
        return super.onCreateOptionsMenu(menu)
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater: MenuInflater = menuInflater
//        inflater.inflate(R.menu.menu_example,menu)
//        return super.onCreateOptionsMenu(menu)
//    }
}