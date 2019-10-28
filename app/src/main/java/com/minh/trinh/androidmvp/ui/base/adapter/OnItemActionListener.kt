package com.minh.trinh.androidmvp.ui.base.adapter

interface OnItemActionListener<Action> {
    fun onItemAction(action: Action, position: Int)

}