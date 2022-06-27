package com.example.android.myapplicationdict.feature_dictionary.data.remote.dto

import com.example.android.myapplicationdict.feature_dictionary.data.local.entities.WordInfoEntity

data class WordInfoDto(

    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            phonetic=phonetic,
            word=word

        )
    }
}