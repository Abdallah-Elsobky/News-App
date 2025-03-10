package com.example.newsv1.ui.fragments.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.newsv1.databinding.FragmentNewsBinding
import com.example.newsv1.domain.constants.Category.Companion.CATEGORY_KEY


class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val categoryId = arguments?.getString(CATEGORY_KEY)
        changeTitle(categoryId?:"General")
    }


    private fun changeTitle(text: String){
        val title = text.replaceFirstChar { it.uppercase() }
        (requireActivity() as AppCompatActivity).supportActionBar?.title = title
    }
}