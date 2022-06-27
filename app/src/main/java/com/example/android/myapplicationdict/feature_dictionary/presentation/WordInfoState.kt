package com.example.android.myapplicationdict.feature_dictionary.presentation

import com.example.android.myapplicationdict.feature_dictionary.domain.models.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean=false
)
