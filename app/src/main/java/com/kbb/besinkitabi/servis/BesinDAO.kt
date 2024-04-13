package com.kbb.besinkitabi.servis

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kbb.besinkitabi.model.Besin
@Dao
interface BesinDAO {
    @Insert
    suspend fun insertAll(vararg besin: Besin):List<Long>
    @Query("Select * From besin")
    suspend fun getAllBesin():List<Besin>
    @Query("Select * From besin WHERE uuid=:besinId")
    suspend fun getBesin(besinId:Int):Besin
    @Query("DELETE FROM besin")
    suspend fun deleteAll()
}