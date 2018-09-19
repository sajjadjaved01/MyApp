package com.quellxcode.myapp

import android.os.AsyncTask
import android.util.Log

object DatabaseInitializer {

    fun populateAsync(db: AppDatabase) {
        val exe = PopulateDbAsync(db)
        exe.execute()
    }

    private class PopulateDbAsync internal constructor(private val mDb: AppDatabase) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg p0: Void?): Void? {
            populateWithTestData(mDb)
            return null
        }

    }

    private fun populateWithTestData(db: AppDatabase) {
        db.userModel().deleteAll()
        addUser(db, "Sajjad", 25)
        addUser(db, "Hassan", 25)
        addUser(db, "Faizan", 25)
        addUser(db, "Zain", 25)
    }

    private fun addUser(db: AppDatabase, name: String, age: Int): Custom {
        val cus = Custom(name, age)
        db.userModel().insertUser(cus)
        Log.d("Google", "All data Inserted")
        return cus
    }
}