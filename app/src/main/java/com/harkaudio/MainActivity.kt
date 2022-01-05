package com.harkaudio


import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.harkaudio.replica.R
import com.harkaudio.replica.databinding.ActivityMainBinding
import com.harkaudio.searchview.Person
import com.harkaudio.searchview.PersonAdapter


class MainActivity : AppCompatActivity() {

    private var navController : LiveData<NavController>? = null

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var people: ArrayList<Person> = arrayListOf()
    private var matchedPeople: ArrayList<Person> = arrayListOf()
    private var personAdapter: PersonAdapter = PersonAdapter(people)

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initRecyclerView()
        performSearch()

//        if(savedInstanceState == null) {
//            setUpBottomNavigation()
//        }
    }

    override fun onResume() {
        initRecyclerView()
        super.onResume()
    }

    private fun initRecyclerView() {

        people = arrayListOf(
            Person("Eric G", 19),
            Person("Reen", 19),
            Person("Jeff", 21),
            Person("Geoffrey", 19),
            Person("Lorem ipsum", 35),
            Person("Paul N", 23),
            Person("Diana", 20),
            Person("Peter", 24),
            Person("Amos", 41),
            Person("Steve", 17),
        )

        personAdapter = PersonAdapter(people).also {
            binding.recyclerView.adapter = it
            binding.recyclerView.adapter!!.notifyDataSetChanged()
        }
        binding.searchView.isSubmitButtonEnabled = true
    }

    private fun performSearch() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                search(newText)
                return true
            }
        })
    }

    private fun search(text: String?) {
        matchedPeople = arrayListOf()

        text?.let {
            people.forEach { person ->
                if (person.name.contains(text, true) ||
                    person.age.toString().contains(text, true)
                ) {
                    matchedPeople.add(person)
                    updateRecyclerView()
                }
            }
            if (matchedPeople.isEmpty()) {
                Toast.makeText(this, "No match found!", Toast.LENGTH_SHORT).show()
            }
            updateRecyclerView()
        }
    }

    private fun updateRecyclerView() {
        binding.recyclerView.apply {
            personAdapter.list = matchedPeople
            personAdapter.notifyDataSetChanged()
        }
    }



//    @RequiresApi(Build.VERSION_CODES.S)
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        setUpBottomNavigation()
//    }
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


//    @RequiresApi(Build.VERSION_CODES.S)
//    private fun setUpBottomNavigation() {
//       val graphsId = listOf(R.navigation.nav_graph, R.navigation.home, R.navigation.search,
//       R.navigation.library, R.navigation.bookmark)
//
//        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
//
//
//        val controller =  bottomNav.setupWithNavController(
//            graphsId,
//            supportFragmentManager,
//            R.id.nav_host_fragment,
//            intent
//
//        )
//        navController = controller
//
//    }






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