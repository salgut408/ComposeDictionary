package com.example.android.myapplicationdict.feature_dictionary.domain.repository

import com.example.android.myapplicationdict.core.util.Resource
import com.example.android.myapplicationdict.feature_dictionary.domain.models.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
//flow for emitted response
    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}