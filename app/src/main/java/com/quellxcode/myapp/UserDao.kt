package com.quellxcode.myapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query

@Dao
interface UserDao {

    @get:Query("Select * From custom")
    val allUsers: List<Custom>

//    @get:Query("Select * From custom")
//    val allUser: ArrayList<Custom>

//    @get:Query("Select * From custom")
//    val allUsersLive: LiveData<ArrayList<Custom>>

    @Insert(onConflict = IGNORE)
    fun insertUser(custom: Custom)

    @Delete
    fun deleteUser(user: Custom)

    @Query("DELETE FROM custom")
    fun deleteAll()

    @Query("select * from custom where id = :id")
    fun loadUserById(id: Int): Custom

    @Query("SELECT * FROM custom WHERE age < :age")
    fun findUsersYoungerThan(age: Int): List<Custom>

    @Query("SELECT * FROM custom WHERE age > :age")
    fun findUsersOlderThan(age: Int): List<Custom>


    @Query("select * from custom where name = :firstName")
    fun findUserByName(firstName: String): List<Custom>
}