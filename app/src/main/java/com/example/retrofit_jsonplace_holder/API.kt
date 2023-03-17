package com.example.retrofit_jsonplace_holder

import com.example.retrofit_jsonplace_holder.model.Post
import com.example.retrofit_jsonplace_holder.model.UsersItem
import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("posts")
    fun getAllPosts(): Call<ArrayList<Post>>

    @GET("users")
    fun getAllUsers(): Call<ArrayList<UsersItem>>
}