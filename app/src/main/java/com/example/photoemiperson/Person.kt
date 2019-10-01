package com.example.photoemiperson

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person (
    val name: String?,
    val age: String?,
    val dob: String?,
    val country: String?) : Parcelable
