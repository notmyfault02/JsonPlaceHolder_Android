package com.example.hellojson.model

import com.google.gson.annotations.SerializedName

data class PhotoModel(
    @SerializedName("albumId")
    val albumId: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String

)