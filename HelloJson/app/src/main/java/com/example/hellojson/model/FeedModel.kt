package com.example.hellojson.model

import com.google.gson.annotations.SerializedName

data class FeedModel(
    @SerializedName("userId")
    val userId: String,
    @SerializedName("id")
    val Id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
)