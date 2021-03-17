package com.example.testforwork.Common

import com.example.testforwork.Interface.RetrofitService
import com.example.testforwork.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://firebasestorage.googleapis.com/v0/b/android-interview-test.appspot.com/o/"

    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}