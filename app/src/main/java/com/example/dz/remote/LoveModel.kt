package com.example.dz.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "love_table")
class LoveModel(
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName : String,
    val persentage : String,
    val result : String,
    @PrimaryKey(autoGenerate = true)
    var id: Int
): Serializable






