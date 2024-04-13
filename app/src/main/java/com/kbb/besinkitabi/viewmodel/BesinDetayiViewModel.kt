package com.kbb.besinkitabi.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kbb.besinkitabi.model.Besin
import com.kbb.besinkitabi.servis.BesinDatabase
import kotlinx.coroutines.launch

class BesinDetayiViewModel(application: Application):BaseViewModel(application) {
    val besinLiveData=MutableLiveData<Besin>()
    fun roomVerisiniAl(uuid:Int){
        launch {
            val dao=BesinDatabase(getApplication()).besinDao()
            val besin = dao.getBesin(uuid)
            besinLiveData.value=besin
        }

    }
}
