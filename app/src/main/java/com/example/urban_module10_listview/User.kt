package com.example.urban_module10_listview

class User(private val name: String, private val age: Int) {
    override fun toString(): String {
        return "$name, возраст: $age"
    }
}