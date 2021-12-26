package com.cpprojects.simpletodo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val task = intent.getStringExtra("text")
        val position = intent.getIntExtra("position", 0)
        val editTextField = findViewById<EditText>(R.id.editTask)
        editTextField.setText(task)

        val saveBtn = findViewById<Button>(R.id.saveChange)
        saveBtn.setOnClickListener {
            val saveBtn = findViewById<Button>(R.id.saveChange)
            val editTaskField = findViewById<EditText>(R.id.editTask)
            // Prepare data intent
            val data = Intent()
            // Pass relevant data back as a result
            data.putExtra("text", editTaskField.getText().toString())
            data.putExtra("position", position)
            data.putExtra("code", 200) // ints work too
            // Activity finished ok, return the data
            setResult(RESULT_OK, data) // set result code and bundle data for response
            finish() // closes the activity, pass data to parent
        }
    }
}