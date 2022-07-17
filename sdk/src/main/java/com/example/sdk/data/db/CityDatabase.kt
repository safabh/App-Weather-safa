package com.example.sdk.data.dao


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sdk.data.model.CityModel

@Database(entities = arrayOf(CityModel::class), version = 1, exportSchema = false)
abstract class CityDataBase : RoomDatabase() {

    abstract fun getCitysDao(): CityDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CityDataBase? = null

        fun getDatabase(context: Context): CityDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CityDataBase::class.java,
                    "city_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }


}