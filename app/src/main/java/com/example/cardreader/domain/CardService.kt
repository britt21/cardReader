package com.example.cardreader.domain

import com.example.cardreader.BuildConfig
import com.example.cardreader.data.card_info.response.CardInfoResponse
import com.example.cardreader.data.card_info.response.new_card_response.NewCardResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface CardInterface {


    @GET("lookup/{cardNumber}")
    suspend fun getCardInfo(
        @Path("cardNumber") cardNumber: String
    ): Response<NewCardResponse>


}

val client = OkHttpClient.Builder()
    .readTimeout(2, TimeUnit.MINUTES)
    .writeTimeout(2, TimeUnit.MINUTES)
    .callTimeout(2, TimeUnit.MINUTES)
    .connectTimeout(2, TimeUnit.MINUTES)
    .build()

val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BuildConfig.BASE_URL)
    .build()

object cardService {


    val cardServiceInstance : CardInterface by lazy {
        retrofit.create(CardInterface::class.java)
    }


}