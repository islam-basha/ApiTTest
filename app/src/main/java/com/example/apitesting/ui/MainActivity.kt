package com.example.apitesting.ui

import PostAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.apitesting.databinding.ActivityMainBinding
import com.example.apitesting.model.PstsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: PstsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = PostAdapter()
        binding.rvPosts.adapter = adapter

        //start observing our data
        viewModel.posts.observe(this) { posts ->
            if (posts.isEmpty()) {
                //show a progress bar if the list is empty
                binding.pbPosts.visibility = View.VISIBLE
            } else {
                //otherwise hide the progress bar
                binding.pbPosts.visibility = View.GONE
                adapter.submitList(posts)
            }
        }
    }
}