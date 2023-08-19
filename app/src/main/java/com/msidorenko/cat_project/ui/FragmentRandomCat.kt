package com.msidorenko.cat_project.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.adapters.AdapterRandomCat
import com.msidorenko.cat_project.databinding.FragmentRandomCatBinding

class FragmentRandomCat : Fragment(R.layout.fragment_random_cat) {

    private lateinit var binding: FragmentRandomCatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRandomCatBinding.bind(view)
        setupRV(view)
    }

    private fun setupRV(view: View) {
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        val adapterRandomCat = AdapterRandomCat()

        binding.rvFragmentRandomCat.apply {
            adapter = adapterRandomCat
            layoutManager = linearLayoutManager
        }

//        view.findViewById<RecyclerView>(R.id.rv_fragmentRandomCat).apply {
//            adapter = adapterRandomCat
//            layoutManager = linearLayoutManager
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random_cat, container, false)
    }
}