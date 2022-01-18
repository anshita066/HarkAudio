package com.harkaudio

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import com.harkaudio.replica.R

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.harkaudio.fragments.search.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var navController : LiveData<NavController>? = null

    private lateinit var viewModel: SearchFragmentViewModel

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this)[SearchFragmentViewModel::class.java]

//        setUpNavigation()

        if(savedInstanceState == null) {
            setUpBottomNavigation()
        }

    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setUpBottomNavigation()
    }
/*        private fun setUpNavigation() {

            val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)

            supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
            NavigationUI.setupWithNavController(
                bottomNavigationView,
                findNavController(R.id.nav_host_fragment)
            )
        }
*/


    @RequiresApi(Build.VERSION_CODES.S)
    private fun setUpBottomNavigation() {
       val graphsId = listOf(R.navigation.nav_graph, R.navigation.home, R.navigation.search,
       R.navigation.library, R.navigation.bookmark)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)


        val controller =  bottomNav.setupWithNavController(
            graphsId,
            supportFragmentManager,
            R.id.nav_host_fragment,
            intent

        )
        navController = controller

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