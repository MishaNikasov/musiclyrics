package com.nikasov.data.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nikasov.data.api.MusixmatchApi
import com.nikasov.data.interceptor.MusixmatchInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

const val GENERAL_TIMEOUT = 15L

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideChucker(@ApplicationContext context: Context): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(context)
            .collector(ChuckerCollector(context))
            .maxContentLength(250000L)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(false)
            .build()
    }

    @Provides
    @Singleton
    @Named("musixmatch")
    fun provideOkHttpClient(
        chuckerInterceptor: ChuckerInterceptor,
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(GENERAL_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(GENERAL_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(GENERAL_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(MusixmatchInterceptor())
            .addInterceptor(chuckerInterceptor)

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideGson() = GsonBuilder()
        .setLenient()
        .create()

    @Provides
    @Singleton
    @Named("musixmatch")
    fun provideRetrofit(@Named("musixmatch") okHttpClient: OkHttpClient, gsonBuilder: Gson): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.musixmatch.com/ws/1.1/") //url from preferences
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
            .build()
    }

    @Provides
    @Singleton
    fun provideNetworkApi(@Named("musixmatch") retrofit: Retrofit): MusixmatchApi {
        return retrofit.create(MusixmatchApi::class.java)
    }

}