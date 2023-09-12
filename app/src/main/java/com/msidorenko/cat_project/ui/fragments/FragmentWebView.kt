package com.msidorenko.cat_project.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.databinding.FragmentBreedInfoBinding
import com.msidorenko.cat_project.databinding.FragmentWebviewBinding
import com.msidorenko.cat_project.ui.CatActivity
import okhttp3.internal.wait

class FragmentWebView : Fragment() {
    private val args: FragmentWebViewArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = (activity as CatActivity).catActivityViewModel
        val binding = FragmentWebviewBinding.bind(view)

        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(args.url)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_webview, container, false)
    }
}