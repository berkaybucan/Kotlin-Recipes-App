package com.kbb.besinkitabi.servis

import com.kbb.besinkitabi.model.Besin
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class BesinAPIServis {

    private val BASE_URL="https://raw.githubusercontent.com/"
    private val api =Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(BesinAPI::class.java)
    fun getData():Single<List<Besin>>{
        return api.getBesin()
    }
}