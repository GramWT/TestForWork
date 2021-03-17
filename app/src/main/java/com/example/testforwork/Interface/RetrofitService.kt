package com.example.testforwork.Interface

import com.example.testforwork.Model.Event
import retrofit2.Call
import retrofit2.http.GET


interface RetrofitService {
    @GET("campaigns.json?alt=media&token=c4aa376e-d07a-49fd-b6d3-a2dd52e9c47f")
    fun getEventList(): Call<MutableList<Event>>
}