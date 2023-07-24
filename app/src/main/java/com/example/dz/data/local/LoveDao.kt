package com.example.dz.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dz.remote.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)

    @Query("Select * FROM love_table")
    fun getAll(): LiveData<List<LoveModel>>

    @Query("Select * FROM love_table ORDER BY firstName ASC")
    fun getAllSort(): List<LoveModel>
}