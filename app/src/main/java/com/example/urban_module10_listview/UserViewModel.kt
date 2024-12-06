package com.example.urban_module10_listview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    var users = mutableListOf<User>()
    val currentUsers: MutableLiveData<MutableList<User>> by lazy { MutableLiveData<MutableList<User>>() }
}