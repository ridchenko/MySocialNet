package com.example.mysocialnet.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize

data class User(
    var name: String,
    var time: Date,
    var status: String,
    var hobby: String,
    var email: String,
    var imgUrl: String,
): Parcelable
