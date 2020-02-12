package com.example.revofitdemo.Services

import com.example.revofitdemo.Main.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("eat_exam_response.json")
    fun doGetListResources(): Call<MainModel>
}