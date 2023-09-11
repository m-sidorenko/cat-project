package com.msidorenko.cat_project.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.msidorenko.cat_project.databinding.MainLayoutBinding
import com.msidorenko.cat_project.db.LikedBreedDatabase
import com.msidorenko.cat_project.repository.LikedBreedRepository
import com.msidorenko.cat_project.ui.fragments.FragmentRandomCatV2

class CatActivity : AppCompatActivity() {

    private val binding by lazy { MainLayoutBinding.inflate(layoutInflater) }
    lateinit var catActivityViewModel: CatViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val db = LikedBreedDatabase(this@CatActivity)

        val repository = LikedBreedRepository(db)

        catActivityViewModel = ViewModelProvider(
            this@CatActivity,
            CatViewModelProvider(repository)
        ).get(CatViewModel::class.java)

        val navController =
            binding.fragmentContainerView.getFragment<FragmentRandomCatV2>().findNavController()

        binding.bottomNavigationView.setupWithNavController(navController)
    }

    private fun hideSystemUI(mainContainer: View) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, mainContainer).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    private fun showSystemUI(mainContainer: View) {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(
            window,
            mainContainer
        ).show(WindowInsetsCompat.Type.systemBars())
    }
}