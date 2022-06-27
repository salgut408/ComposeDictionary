package com.example.android.myapplicationdict.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.android.myapplicationdict.core.util.JsonParser
import com.example.android.myapplicationdict.feature_dictionary.domain.models.Meaning
import com.google.gson.reflect.TypeToken
@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
   fun toMeaningsJson(meanings: List<Meaning>): String {
       return jsonParser.toJson(
           meanings,
           object : TypeToken<ArrayList<Meaning>>(){}.type

       ) ?: "[]"
   }























}