package com.example.common.base

import android.os.Parcelable

abstract class BaseObject: Parcelable {
    public open val id: Int = 0
}