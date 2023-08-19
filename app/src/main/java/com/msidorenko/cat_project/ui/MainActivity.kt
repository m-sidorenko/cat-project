package com.msidorenko.cat_project.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
         ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navController = binding.fragmentContainerView.getFragment<FragmentRandomCat>().findNavController()
        binding.bottomNavigationView.setupWithNavController(
            navController
        )
    }
}