package com.example.android.myapplicationdict.feature_dictionary.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.myapplicationdict.feature_dictionary.domain.models.Meaning
import com.example.android.myapplicationdict.feature_dictionary.domain.models.WordInfo

@Entity
data class WordInfoEntity(
    val meanings: List<Meaning>,
    val phonetic: String,
    val word: String,
    @PrimaryKey val id: Int? = null

) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings=meanings,
            phonetic=phonetic,
            word= word
        )

    }
}
