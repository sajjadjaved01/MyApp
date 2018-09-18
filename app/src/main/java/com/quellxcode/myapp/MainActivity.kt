package com.quellxcode.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BaseObservable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.quellxcode.myapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val items: ArrayList<Custom> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        items.add(Custom("Sajjad"))
        items.add(Custom("Hassan"))
        items.add(Custom("Faizan"))
        items.add(Custom("Zain"))

        bind.recycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        bind.recycler.itemAnimator = DefaultItemAnimator()
        bind.recycler.adapter = CustomAdapter(items)

        val cus = Custom("Sajjad")
        bind.data = cus

    }
}

class Custom(val name: String?) : BaseObservable()