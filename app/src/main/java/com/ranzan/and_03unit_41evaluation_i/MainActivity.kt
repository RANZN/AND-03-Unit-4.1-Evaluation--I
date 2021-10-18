package com.ranzan.and_03unit_41evaluation_i

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ranzan.and_03unit_41evaluation_i.Database.DatabaseHelper
import com.ranzan.and_03unit_41evaluation_i.Database.DatabaseModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var dataBase: DatabaseHelper
    private var list: MutableList<DatabaseModel> = mutableListOf()
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addDataBtn.setOnClickListener {
            val intent = Intent(MainActivity@ this, AddDataActivity::class.java)
            startActivity(intent)
        }
        dataBase = DatabaseHelper(this)
        list = dataBase.getDBList()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        recyclerViewAdapter = RecyclerViewAdapter(list)
        recyclerView.run {
            adapter = recyclerViewAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}