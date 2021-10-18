package com.ranzan.and_03unit_41evaluation_i

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ranzan.and_03unit_41evaluation_i.Database.DatabaseHelper
import kotlinx.android.synthetic.main.activity_add_data.*
import kotlinx.android.synthetic.main.activity_main.*

class AddDataActivity : AppCompatActivity() {
    private lateinit var dataBase: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)
        dataBase = DatabaseHelper(this)

        if (intent != null && intent.extras != null) {
            val pos = intent.getIntExtra("pos", 0)
            modifyData(pos)
        } else {
            submitButton.setOnClickListener {
                dataBase.addDBData(
                    eventName.text.toString(),
                    eventDate.text.toString(),
                    eventLocation.text.toString(),
                    eventDesc.text.toString(),
                    eventPrice.text.toString().toInt()
                )
                Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show()
                val intent = Intent(AddDataActivity@ this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun modifyData(pos: Int) {
        deleteButton.visibility = View.VISIBLE
        val databaseModel = dataBase.getData(pos)
        val id = databaseModel.id
        val name = databaseModel.eventName
        val date = databaseModel.eventDate
        val location = databaseModel.eventLocation
        val desc = databaseModel.eventDesc
        val price = databaseModel.eventPrice
        eventName.setText(name)
        eventDate.setText(date)
        eventLocation.setText(location)
        eventDesc.setText(desc)
        eventPrice.setText(price.toString())

        deleteButton.setOnClickListener {
            dataBase.delete(id)
            val intent = Intent(AddDataActivity@ this, MainActivity::class.java)
            startActivity(intent)
        }
        submitButton.setOnClickListener {
            dataBase.updateData(
                id,
                eventName.text.toString(),
                eventDate.text.toString(),
                eventLocation.text.toString(),
                eventDesc.text.toString(),
                eventPrice.text.toString().toInt()
            )
            val intent = Intent(AddDataActivity@ this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}