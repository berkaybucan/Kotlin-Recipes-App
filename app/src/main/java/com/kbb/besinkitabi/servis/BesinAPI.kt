package com.kbb.besinkitabi.servis

import com.kbb.besinkitabi.model.Besin
import io.reactivex.Single
import retrofit2.http.GET

interface BesinAPI {
     @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
     fun getBesin():Single<List<Besin>>
}