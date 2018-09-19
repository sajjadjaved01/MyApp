package com.quellxcode.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BaseObservable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.quellxcode.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        bind.recycler.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        bind.recycler.itemAnimator = DefaultItemAnimator()

        fetchData(bind)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppDatabase.destroy()
    }

    private fun fetchData(bind: ActivityMainBinding) {
        val db: AppDatabase = AppDatabase.getInMemoryDb(applicationContext)
        DatabaseInitializer.populateAsync(db)

        val get = db.userModel().allUsers
        bind.recycler.adapter = CustomAdapter(get)
    }
}

@Entity
data class Custom(
        val name: String?,
        val age: Int? = 0,
        @PrimaryKey(autoGenerate = true) val Id: Int = 0
) : BaseObservable()