package com.quellxcode.myapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Custom::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userModel(): UserDao

    companion object {

        var Instance: AppDatabase? = null

        fun getInMemoryDb(ctx: Context): AppDatabase {
            if (Instance == null) {
                Instance = Room.databaseBuilder<AppDatabase>(ctx.applicationContext, AppDatabase::class.java, "users-db")
                        .allowMainThreadQueries()
                        .build()
            }
            return Instance as AppDatabase
        }

        fun destroy() {
            Instance = null
        }
    }
}