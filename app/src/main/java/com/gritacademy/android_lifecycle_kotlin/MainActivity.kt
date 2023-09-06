package com.gritacademy.android_lifecycle_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText

import android.widget.Toast
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import com.google.android.material.bottomnavigation.BottomNavigationView


//TODO Man ska kunna skicka datan någonstans?
//TODO Datan ska sparas i formuläret om man inte slutför det
//TODO fråga Alrik om vad han menar med att skicka datan. Firebase?

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener(View.OnClickListener {
            val usernameInputElement = findViewById<EditText>(R.id.usernameInput)
            val passwordInputElement = findViewById<EditText>(R.id.passwordInput)
            val enteredUsername = usernameInputElement.text.toString()
            val enteredPassword = passwordInputElement.text.toString()
            if (enteredUsername == "Kalle" && enteredPassword == "Kanel") {
                val a1 = Intent(this@MainActivity, LoggedInActivity::class.java)
                startActivity(a1)
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "wrong username or Password. Correct username is 'Kalle' and correct Password is 'Kanel' ",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.loginInOut -> {
//                    loadFragment(ProfileFragment(),false)
                    true
                }

                else -> {
                    Toast.makeText(
                        this@MainActivity,
                        "You need to be logged in to access that page ",
                        Toast.LENGTH_LONG
                    ).show()
                    true

                }
            }
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_example, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
