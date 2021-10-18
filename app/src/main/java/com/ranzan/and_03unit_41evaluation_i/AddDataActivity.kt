package com.ranzan.and_03unit_41evaluation_i

import android.content.Intent
import android.os.Bundle
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