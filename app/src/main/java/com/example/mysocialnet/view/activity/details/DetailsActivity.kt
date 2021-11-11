package com.example.mysocialnet.view.activity.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.mysocialnet.R
import com.example.mysocialnet.data.entity.User
import com.example.mysocialnet.databinding.ActivityDetailsBinding
import com.example.mysocialnet.utils.USR_ARG
import com.example.mysocialnet.utils.getUserTimeString
import com.example.mysocialnet.utils.loadCircular

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        intent.extras?.getParcelable<User>(USR_ARG)?.let {
            initUserData(it)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initUserData(user: User) = with(binding) {
        txtEmail.text = user.email
        txtHobby.text = user.hobby
        txtStatus.text = user.status
        txtUserName.text = user.name
        txtWasOnline.text = user.time.getUserTimeString(this@DetailsActivity)
        imgProfileIcon.loadCircular(user.imgUrl, R.drawable.ic_user_placeholder)
    }

}