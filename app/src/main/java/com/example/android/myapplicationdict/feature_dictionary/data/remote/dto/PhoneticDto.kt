package com.example.android.myapplicationdict.feature_dictionary.data.remote.dto

data class PhoneticDto(
    val audio: String,
    val license: LicenseX,
    val sourceUrl: String,
    val text: String
)