package com.example.urban_module10_listview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var mainToolbar: Toolbar

    private lateinit var nameET: EditText
    private lateinit var ageET: EditText

    private lateinit var saveBTN: Button

    private lateinit var usersLV: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainToolbar = findViewById(R.id.mainToolbar)
        setSupportActionBar(mainToolbar)
        mainToolbar
        title = "Каталог пользователей"

        nameET = findViewById(R.id.nameET)
        ageET = findViewById(R.id.ageET)

        saveBTN = findViewById(R.id.saveBTN)

        usersLV = findViewById(R.id.usersLV)

        val users = mutableListOf<User>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        usersLV.adapter = adapter

        saveBTN.setOnClickListener {
            if (nameET.text.isNotEmpty() && ageET.text.isNotEmpty()) {
                users.add(User(nameET.text.toString(), ageET.text.toString().toInt()))
                adapter.notifyDataSetChanged()
                nameET.text.clear()
                ageET.text.clear()
            }
            else {
                if (nameET.text.isEmpty()) nameET.error = "Введите значение"
                if (ageET.text.isEmpty()) ageET.error = "Введите значение"
            }
        }

        usersLV.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val user = adapter.getItem(position)
                adapter.remove(user)
                users.remove(user)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}