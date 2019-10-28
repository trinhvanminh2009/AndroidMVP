package com.minh.trinh.androidmvp.ui.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<ItemModel, ViewHolder : BaseViewHolder> constructor(
    val listener: OnItemActionListener<BaseItemAction<ItemModel>>,
    diffCallBack: DiffUtil.ItemCallback<ItemModel>
) : ListAdapter<ItemModel, ViewHolder>(diffCallBack) {

    abstract fun getViewHolder(itemView: View): ViewHolder

    abstract fun getViewResId(): Int

    abstract fun updateData(v: View, itemModel: ItemModel, holder: ViewHolder, position: Int)

    fun clear() = submitList(ArrayList())


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        getViewHolder(LayoutInflater.from(parent.context).inflate(getViewResId(), parent, false))

    override fun getItem(position: Int): ItemModel? {
        if (position in 0 until itemCount) {
            return super.getItem(position)
        }
        return null
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            updateData(holder.itemView, it, holder, position)
        }
    }

}