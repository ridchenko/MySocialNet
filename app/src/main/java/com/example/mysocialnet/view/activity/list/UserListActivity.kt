package com.example.mysocialnet.view.activity.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.mysocialnet.R
import com.example.mysocialnet.data.entity.User
import com.example.mysocialnet.databinding.ActivityUserListBinding
import com.example.mysocialnet.utils.USR_ARG
import com.example.mysocialnet.utils.getUserTimeString
import com.example.mysocialnet.view.activity.details.DetailsActivity
import com.example.mysocialnet.view.custom.UserItem

class UserListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserListBinding
    private val viewModel: UserListViewModel by viewModels()

    private var userItems: List<UserItem> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUserListBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initUserItems()
        initViewModel()
    }

    private fun initUserItems() = with(binding) {
        userItems = listOf(user0, user1, user2, user3, user4, user5, user6, user7)
    }

    private fun initViewModel() = with(viewModel) {
        users().observe(this@UserListActivity) { users ->
            users.forEachIndexed { index, user ->
                with(userItems[index]) {
                    name = user.name
                    imgUrl = user.imgUrl
                    time = user.time.getUserTimeString(this@UserListActivity)
                    setItemClickListener(user)
                }
            }
        }
    }

    private fun UserItem.setItemClickListener(user: User) {
        setOnClickListener {
            startActivity(
                Intent(
                    this@UserListActivity,
                    DetailsActivity::class.java
                ).apply { putExtra(USR_ARG, user) }
            )
        }
    }

}