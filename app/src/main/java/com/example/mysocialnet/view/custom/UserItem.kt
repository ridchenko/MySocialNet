package com.example.mysocialnet.view.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.example.mysocialnet.R
import com.example.mysocialnet.databinding.ViewUserItemBinding
import com.example.mysocialnet.utils.EMPTY_STRING
import com.example.mysocialnet.utils.load
import com.example.mysocialnet.utils.loadCircular

class UserItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding = ViewUserItemBinding.inflate(LayoutInflater.from(context), this, true)

    var time: String = EMPTY_STRING
        set(value) {
            field = value
            setViewTime(value)
        }
    var name: String = EMPTY_STRING
        set(value) {
            field = value
            setViewName(value)
        }
    var imgUrl: String = EMPTY_STRING
        set(value) {
            field = value
            setViewImgUrl(value)
        }

    private fun setViewTime(time: String) = with(binding.txtUserTime) {
        text = time
    }

    private fun setViewName(name: String) = with(binding.txtUserName) {
        text = name
    }

    private fun setViewImgUrl(imgUrl: String) = with(binding.imgProfileIcon) {
        loadCircular(imgUrl, R.drawable.ic_user_placeholder)
    }
}