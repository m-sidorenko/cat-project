package com.msidorenko.cat_project.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.msidorenko.cat_project.databinding.ActivityMainBinding
import com.msidorenko.cat_project.db.LikedBreedsDatabase
import com.msidorenko.cat_project.repository.LikedBreedRepository
import com.msidorenko.cat_project.ui.fragments.FragmentRandomCat

class CatActivity : AppCompatActivity() {
    private val repository by lazy {
        LikedBreedRepository(LikedBreedsDatabase.getDatabase(this@CatActivity))
    }

    val catActivityViewModel by lazy {
        ViewModelProvider(this@CatActivity, CatViewModelProvider(repository))
            .get(CatViewModel::class.java)
    }

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navController =
            binding.fragmentContainerView.getFragment<FragmentRandomCat>().findNavController()

        binding.bottomNavigationView.setupWithNavController(
            navController
        )
    }
}