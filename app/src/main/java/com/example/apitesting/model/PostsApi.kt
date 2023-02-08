package com.example.apitesting.model

interface PostsApi {
    suspend fun getPosts(): List<PostResponse>
}