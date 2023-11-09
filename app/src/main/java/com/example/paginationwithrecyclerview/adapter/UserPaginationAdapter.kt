package com.example.paginationwithrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationwithrecyclerview.databinding.LoadItemBinding
import com.example.paginationwithrecyclerview.databinding.UserItemBinding
import com.example.paginationwithrecyclerview.models.Data
import com.squareup.picasso.Picasso

class UserPaginationAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val LOADING = 0
    private val ITEM = 1
    private var isLoadingAdded = false
    private var userList = ArrayList<Data>()

    fun addAll(list: List<Data>) {
        list.forEach {
            add(it)
        }
    }

    fun addLoadingFooter() {
        isLoadingAdded = true
        add(Data())
    }

    fun add(data: Data) {
        userList.add(data)
        notifyItemInserted(userList.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM) {
            return DataVh(
                UserItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        } else {
            return LoadVh(
                LoadItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }

    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == ITEM) {
            val dataVh = holder as DataVh
            dataVh.onBind(userList[position])
        } else {
            val loadVh = holder as LoadVh
            loadVh.onBind()
        }

    }

    override fun getItemViewType(position: Int): Int {
        if (position == userList.size - 1 && isLoadingAdded) return LOADING
        return ITEM
    }

    inner class DataVh(var userItemBinding: UserItemBinding) :
        RecyclerView.ViewHolder(userItemBinding.root) {
        fun onBind(data: Data) {
            userItemBinding.apply {
                Picasso.get().load(data.avatar)
                fullNameTv.text = data.firstName + " " + data.lastName
                emailTv.text = data.email
            }
        }
    }

    inner class LoadVh(var loadItemBinding: LoadItemBinding) :
        RecyclerView.ViewHolder(loadItemBinding.root) {

        fun onBind() {
            loadItemBinding.progress.visibility = View.VISIBLE
        }
    }


}