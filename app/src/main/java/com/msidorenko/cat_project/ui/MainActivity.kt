package com.msidorenko.cat_project.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.msidorenko.cat_project.databinding.ActivityMainBinding
import com.msidorenko.cat_project.ui.fragments.FragmentRandomCat

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityViewModel: ActivityViewModel
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navController =
            binding.fragmentContainerView.getFragment<FragmentRandomCat>().findNavController()
        binding.bottomNavigationView.setupWithNavController(
            navController
        )

        mainActivityViewModel = ActivityViewModel()
    }
}