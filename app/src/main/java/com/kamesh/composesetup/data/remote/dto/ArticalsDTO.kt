package com.kamesh.composesetup.data.remote.dto

import com.google.gson.annotations.SerializedName



data class ArticalsDTO(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("section")
    val section: String,
    @SerializedName("status")
    val status: String
)