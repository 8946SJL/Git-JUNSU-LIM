package com.example.fragmenttest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmenttest.R

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showNavigation()
    }

    private fun showNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_home_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigationView = binding.bottomNav
        bottomNavigationView.setupWithNavController(navController)
    }
}