package com.example.apitesting.model

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
//    val id: String,
//    val title: String,
//    val content: String,
//    val slug: String,
//    val picture: String,
//    val user: String
    val place_id: Int,
    val osm_type:String,
    val licence:String,
    val category:String,
    val display_name:String,
)
