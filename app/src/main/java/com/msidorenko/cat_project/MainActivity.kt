package com.msidorenko.cat_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.msidorenko.cat_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        val navController = binding.fragmentContainerView.getFragment<FragmentRandomCat>().findNavController()
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setupWithNavController(navController)
    }
}