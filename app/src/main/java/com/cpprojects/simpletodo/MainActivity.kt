package com.cpprojects.simpletodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    var listOfTasks = mutableListOf<String>()
    lateinit var adapter : TaskItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val longClickListener = object : TaskItemAdapter.OnLongClickListener {
            override fun onItemLongClicked(position: Int) {
                // remove the item from the list
                listOfTasks.removeAt(position)

                // notify the adapter that our data has changed
                adapter.notifyDataSetChanged()

                // save the tasks
                saveItems()
            }

        }

        // first load items to populate the view with the saved data
        loadItems()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = TaskItemAdapter(listOfTasks, longClickListener)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val inputTextField = findViewById<EditText>(R.id.addTaskField)

        // set up the button and input field so that user can enter a task
        findViewById<Button>(R.id.button).setOnClickListener {

            // grab the text and add the string to list of tasks
            val userInputtedTask = inputTextField.text.toString()
            listOfTasks.add(userInputtedTask)

            // notify the adapter that data has been updated
            adapter.notifyItemInserted(listOfTasks.size - 1)

            // clear out the input field after the item being added
            inputTextField.setText("")

            // save the tasks
            saveItems()
        }
    }

    // save the data that the user has inputted by writing to and reading from a file
    // get the file we need
    fun getDataFile() : File {
        return File(filesDir, "data.txt")
    }

    // load the item by reading every line in the file
    fun loadItems() {
        try {
            listOfTasks = FileUtils.readLines(getDataFile(), Charset.defaultCharset())
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }
    }

    // write data to the file
    fun saveItems() {
        try {
            FileUtils.writeLines(getDataFile(), listOfTasks)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }

    }
}