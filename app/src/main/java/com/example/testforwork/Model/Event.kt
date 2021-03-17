package com.example.testforwork.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(
    var name:String? ,
    var price:String? ,
    var image_url:String? ,
    var description:String?
):Parcelable