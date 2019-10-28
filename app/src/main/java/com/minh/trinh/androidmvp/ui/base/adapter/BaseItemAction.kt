package com.minh.trinh.androidmvp.ui.base.adapter

sealed class BaseItemAction<out T> {
    class OnItemRowClick<T>(val item :T):BaseItemAction<T>()
}