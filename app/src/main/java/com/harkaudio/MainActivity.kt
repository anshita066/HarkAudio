package com.harkaudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import com.harkaudio.replica.R

import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpNavigation();
    }
        private fun setUpNavigation() {

            val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)

            supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
            NavigationUI.setupWithNavController(
                bottomNavigationView,
                findNavController(R.id.nav_host_fragment)
            )
        }

}















/*
    val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)

        val navController = findNavController(R.id.fragment)

        //Setting the navigation controller to Bottom Nav
        bottomNav.setupWithNavController(navController)

        //Setting up the action bar
        NavigationUI.setupActionBarWithNavController(this, navController)

        bottomNavigationView?.setOnItemSelectedListener {  item ->
            when(item.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.home)
                }
                R.id.search-> {
                    navController.navigate(R.id.search)
                }
                R.id.library-> {
                    navController.navigate(R.id.library)
                }
                R.id.bookmark-> {
                    navController.navigate(R.id.library)
                }
                else -> navController.navigate(R.id.fragment)
            }
            return@setOnItemSelectedListener true
        }


        //Setting Up the back button
        fun onSupportNavigateUp(): Boolean {
            return NavigationUI.navigateUp(navController, null)
        }

        */