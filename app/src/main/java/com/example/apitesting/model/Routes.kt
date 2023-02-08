package com.example.apitesting.model

object Routes {
    private const val BASE_URL = "https://nominatim.openstreetmap.org/"

     const val POSTS = "$BASE_URL/search.php?city=taipei&format=jsonv2"
}