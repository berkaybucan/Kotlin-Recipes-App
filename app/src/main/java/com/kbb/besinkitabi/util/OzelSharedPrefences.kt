package com.kbb.besinkitabi.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class OzelSharedPrefences {
    companion object{
        private val ZAMAN="zaman"
        private var sharedPrefences:SharedPreferences?=null
        @Volatile private var instance:OzelSharedPrefences?=null
        private val lock =Any()
        operator fun invoke(context: Context):OzelSharedPrefences= instance?: synchronized(lock){
            instance?: ozelSharedPrefencesYap(context).also {
                instance=it

            }

        }
        private fun ozelSharedPrefencesYap(context: Context):OzelSharedPrefences{
            sharedPrefences=androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
            return OzelSharedPrefences()

        }
    }
    fun zamaniKaydet(zaman:Long){
        sharedPrefences?.edit(commit=true){
            putLong(ZAMAN,zaman)

        }
    }
    fun zamaniAl()= sharedPrefences?.getLong(ZAMAN,0)
}