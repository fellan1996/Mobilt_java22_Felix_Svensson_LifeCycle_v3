package com.gritacademy.android_lifecycle_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.view.View
import android.widget.Button
import android.widget.EditText

import android.widget.Toast
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class LoggedInActivity : AppCompatActivity() {
    companion object {
        lateinit var sharedPref: SharedPreferences
        lateinit var editor: SharedPreferences.Editor
    }

    private lateinit var bottomNav: BottomNavigationView

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPref = getSharedPreferences(getString(R.string.preferences), MODE_PRIVATE)
        editor = sharedPref.edit()
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
                        "Something went wrong, try pressing again ",
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
