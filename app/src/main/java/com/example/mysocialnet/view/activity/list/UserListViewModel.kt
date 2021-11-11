package com.example.mysocialnet.view.activity.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mysocialnet.data.entity.User
import com.example.mysocialnet.data.source.UsersData

class UserListViewModel: ViewModel() {

    private val users = MutableLiveData<List<User>>()
    fun users() = users as LiveData<List<User>>

    init {
        getUsers()
    }

    private fun getUsers() = users.postValue(UsersData.getUsersData())


}