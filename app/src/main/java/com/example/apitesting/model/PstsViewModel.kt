package com.example.apitesting.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PstsViewModel: ViewModel(){
    private var postsApi: PostsApi = PostsApiImplemintation(Provider.client)
    private val _posts: MutableLiveData<List<PostResponse>> = MutableLiveData()
    val posts: LiveData<List<PostResponse>> get() = _posts

    init {
        loadPostsFromApi()
    }

    fun loadPostsFromApi(){
        viewModelScope.launch {
            _posts.value = postsApi.getPosts()
        }
    }
}