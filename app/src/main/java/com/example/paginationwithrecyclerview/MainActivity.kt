package com.example.paginationwithrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paginationwithrecyclerview.adapter.UserPaginationAdapter
import com.example.paginationwithrecyclerview.databinding.ActivityMainBinding
import com.example.paginationwithrecyclerview.models.UserData
import com.example.paginationwithrecyclerview.networking.ApiClient
import com.example.paginationwithrecyclerview.networking.ApiService
import com.example.paginationwithrecyclerview.pagination.PaginationScrollListener
import com.example.paginationwithrecyclerview.vm.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: UserViewModel
    lateinit var binding: ActivityMainBinding
    lateinit var apiService: ApiService
    lateinit var userPaginationAdapter: UserPaginationAdapter


    private var currentPage = 1
    private var TOTAL_PAGES = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        apiService = ApiClient.getRetrofit().create(ApiService::class.java)
        // Pagination with RecyclerView

        //1. Custom pagination
        //2. Paging3 library

        val layoutLayoutManager = LinearLayoutManager(this)
        binding.rv.layoutManager = layoutLayoutManager

//        binding.rv.addOnScrollListener(object : PaginationScrollListener(layoutManager) {
//            override fun loadMoreItems() {
//                TODO("Not yet implemented")
//            }
//
//            override fun isLastPage(): Boolean {
//                TODO("Not yet implemented")
//            }
//
//            override fun isLoading(): Boolean {
//                TODO("Not yet implemented")
//            }
//
//        })
    }

    fun loadFirstPage() {
        apiService.getUsers(1)
            .enqueue(object : Callback<UserData> {
                override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: Call<UserData>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }

}