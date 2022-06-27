package com.example.android.myapplicationdict.feature_dictionary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.android.myapplicationdict.feature_dictionary.data.local.entities.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class],
    version = 2, exportSchema = false
)

@TypeConverters(Converters::class)
abstract class WordInfoDatabase: RoomDatabase() {
    abstract val dao: WordInfoDao
}