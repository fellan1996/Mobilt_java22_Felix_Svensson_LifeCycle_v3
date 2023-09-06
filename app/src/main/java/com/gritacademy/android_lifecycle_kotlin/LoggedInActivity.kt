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
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


//TODO Man ska inte kunna komma in i form om man inte är inloggad
//TODO Log in knappen ska ändras till en profilknapp om man är inloggad
//TODO Man ska kunna skicka datan någonstans?
//TODO Datan ska sparas i formuläret om man inte slutför det
//TODO Vissa fält ska vara obligatoriska
//TODO Man ska kunna logga in och automatiskt hamna på home-fragmentet
//TODO fråga Alrik om vad han menar med att skicka datan. Firebase?

class LoggedInActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)
        loadFragment(HomeFragment(), true)

        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.homeBtn -> {
                    loadFragment(HomeFragment(), false)

                    true
                }

                R.id.formBtn -> {
                    loadFragment(FormFragment(), false)
                    true
                }

                R.id.loginInOut -> {
                    loadFragment(ProfileFragment(), false)
                    true
                }

                else -> {
                    Toast.makeText(
                        this@LoggedInActivity,
                        "wrong username or Password. Correct username is 'Kalle' and correct Password is 'Kanel' ",
                        Toast.LENGTH_LONG
                    ).show()
                    true

                }
            }
        }

    }

    private fun loadFragment(fragment: Fragment, initial: Boolean) {
        if (initial) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment::class.java, null).commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment::class.java, null).commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_example, menu)
        return super.onCreateOptionsMenu(menu)
    }
}