package com.sryang.torang_repository.di.api

import android.content.Context
import com.example.torangrepository.R
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.sryang.torang_repository.api.ApiFeed
import com.sryang.torang_repository.data.Favorite
import com.sryang.torang_repository.data.Like
import com.sryang.torang_repository.data.Review
import com.sryang.torang_repository.data.entity.ReviewDeleteRequestVO
import com.sryang.torang_repository.data.remote.response.RemoteFeed
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import java.io.StringWriter
import java.io.Writer
import javax.inject.Inject
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class ApiFeedModule {
    @Singleton
    @Provides
    fun provideRemoteFeedService(
        apiFeed: ProductApiFeed
    ): ApiFeed {
        return apiFeed.create()
    }
}

/**
 * 피드 서비스 Product
 */
@Singleton
class ProductApiFeed @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
) {
    private var url = "http://sarang628.iptime.org:8081/"
    fun create(): ApiFeed {
        return retrofitModule
//            .getRetrofit(torangOkHttpClientImpl.getUnsafeOkHttpClient(), url)
            .getRetrofit(torangOkHttpClientImpl.getHttpClient(), url)
            .create(ApiFeed::class.java)
    }
}

/**
 * 로컬 서버 피드 서비스
 */
@Singleton
class LocalApiFeed @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
) {
    private var url = "http://10.0.2.2:8080/"
    fun create(): ApiFeed {
        return retrofitModule.getRetrofit(torangOkHttpClientImpl.getHttpClient(), url).create(
            ApiFeed::class.java
        )
    }
}

@Singleton
class TestFeedServiceImpl @Inject constructor(
    @ApplicationContext val context: Context
) : ApiFeed {
    override suspend fun getFeeds(params: Map<String, String>): List<RemoteFeed> {
        val feeds = ArrayList<RemoteFeed>()
        val list = JsonDataLoader<List<JsonObject>>(context).load(R.raw.feed_response1)
        for (jsonObject in list) {
            try {
                feeds.add(jsonObject.toFeedResponse())
            } catch (e: Exception) {
            }
        }
        return feeds
    }

    override suspend fun deleteReview(review: ReviewDeleteRequestVO): Review {
        TODO("Not yet implemented")
    }

    override suspend fun addLike(like: Like): Like {
        TODO("Not yet implemented")
    }

    override suspend fun deleteLike(like: Like): Like {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFavorite(favorite: Favorite): Favorite {
        TODO("Not yet implemented")
    }

    override suspend fun addFavorite(favorite: Favorite): Favorite {
        TODO("Not yet implemented")
    }

    private fun JsonObject.toFeedResponse(): RemoteFeed {
        return Gson().fromJson(this, RemoteFeed::class.java)
    }
}

class JsonDataLoader<T> constructor(val context: Context) {
    fun load(raw: Int): List<JsonObject> {
        val inputStrem: InputStream = context.resources.openRawResource(raw)
        val writer: Writer = StringWriter()
        val buffer = CharArray(1024)
        try {
            val reader: Reader = BufferedReader(InputStreamReader(inputStrem, "UTF-8"))
            var n: Int
            while (reader.read(buffer).also { n = it } != -1) {
                writer.write(buffer, 0, n)
            }
        } finally {
            inputStrem.close()
        }

        val jsonString = writer.toString()

        val gson = Gson()
        val list = gson.fromJson<List<JsonObject>>(
            jsonString,
            object : TypeToken<List<JsonObject>>() {}.type
        )
        return list
    }
}