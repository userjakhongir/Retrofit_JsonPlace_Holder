package com.example.retrofit_jsonplace_holder.model

import com.example.retrofit_jsonplace_holder.Company

data class UsersItem(
    val company: Company,
    val email: String,
    val phone: String,
    val website: String
)