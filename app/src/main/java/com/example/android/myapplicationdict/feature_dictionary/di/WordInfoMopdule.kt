package com.example.android.myapplicationdict.feature_dictionary.di

import android.app.Application
import androidx.room.Room
import com.example.android.myapplicationdict.core.util.GsonParser
import com.example.android.myapplicationdict.feature_dictionary.data.local.Converters
import com.example.android.myapplicationdict.feature_dictionary.data.local.WordInfoDao
import com.example.android.myapplicationdict.feature_dictionary.data.local.WordInfoDatabase
import com.example.android.myapplicationdict.feature_dictionary.data.remote.DictionaryApi
import com.example.android.myapplicationdict.feature_dictionary.data.remote.DictionaryApi.Companion.BASE_URL
import com.example.android.myapplicationdict.feature_dictionary.data.repository.WordInfoRepositoryImp
import com.example.android.myapplicationdict.feature_dictionary.domain.repository.WordInfoRepository
import com.example.android.myapplicationdict.feature_dictionary.domain.use_case.GetWordInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoMopdule {
    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository)
    }


    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: WordInfoDatabase,
        api: DictionaryApi
    ): WordInfoRepository {
        return WordInfoRepositoryImp(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app, WordInfoDatabase::class.java, "word_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

@Provides
@Singleton
fun provideDictionaryApi(): DictionaryApi {
    return Retrofit.Builder()
        .baseUrl(DictionaryApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DictionaryApi::class.java)
}


}









