package com.example.android.myapplicationdict.feature_dictionary.data.repository

import com.example.android.myapplicationdict.core.util.Resource
import com.example.android.myapplicationdict.feature_dictionary.data.local.WordInfoDao
import com.example.android.myapplicationdict.feature_dictionary.data.remote.DictionaryApi
import com.example.android.myapplicationdict.feature_dictionary.domain.models.WordInfo
import com.example.android.myapplicationdict.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImp(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
): WordInfoRepository {
// all data sources - cache
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

    val wordInfos = dao.getWordInfos(word).map { it.toWordInfo() }

    emit(Resource.Loading(data = wordInfos))

    try {
        val remoteWordInfos = api.getWordInfo(word)
        dao.deleteWordInfos(remoteWordInfos.map {it.word})
        dao.insertWordInfos(remoteWordInfos.map {it.toWordInfoEntity()})


    } catch (e: HttpException) {
        emit(Resource.Error("SOMTHING WENT WRONG", data = wordInfos))

    } catch (e: IOException) {
        emit(Resource.Error("SOMTHING WENT WRONG", data = wordInfos))
    }

    val newWordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfos))
    }

}


























































































