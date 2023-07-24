package com.example.dz

import android.content.Context
import androidx.room.Room
import com.example.dz.data.local.AppDataBase
import com.example.dz.data.local.LoveDao
import com.example.dz.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun provideUtils(): Utils {
        return Utils()
    }

    @Singleton
    @Provides
    fun providePref(@ApplicationContext context: Context): Pref {
        return Pref(context)
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app: Context): AppDataBase = Room.databaseBuilder(
        app, AppDataBase::class.java,
        "love_table"
    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideDao(db: AppDataBase): LoveDao {
        return db.getDao()
    }

}