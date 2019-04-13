package com.example.hellojson.connect

import com.example.hellojson.model.FeedModel
import com.example.hellojson.model.PhotoModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface API {

    @GET("/posts")
    fun getFeed(): Call<ArrayList<FeedModel>>

    @GET("/photos")
    fun getPhoto(): Call<ArrayList<PhotoModel>>

    @POST("/posts")
    fun post(@Body body: Any?): Call<Unit>
}