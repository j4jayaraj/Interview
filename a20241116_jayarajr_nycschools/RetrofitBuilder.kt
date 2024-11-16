package com.example.a20241116_jayarajr_nycschools

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    fun retrofitInstance(): APIClient {
        val API: APIClient by lazy {
            Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIClient::class.java)
        }
        return API
    }
}

