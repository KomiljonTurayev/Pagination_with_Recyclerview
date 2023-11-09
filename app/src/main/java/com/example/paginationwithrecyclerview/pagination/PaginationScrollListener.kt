package com.example.paginationwithrecyclerview.pagination

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class PaginationScrollListener(val layoutManager: LinearLayoutManager) :
    RecyclerView.OnScrollListener() {

    private val TAG = "PaginationScroolListener"
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
        Log.d(TAG, "onScrolled: visible item count: $visibleItemCount")
        Log.d(TAG, "onScrolled: total item count: $totalItemCount")
        Log.d(TAG, "onScrolled: firstVisibleItem count: $firstVisibleItemPosition")

        if (!isLoading() && !isLastPage()) {
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0) {
                loadMoreItems()
            }
        }
    }

    abstract fun loadMoreItems()

    abstract fun isLastPage(): Boolean

    abstract fun isLoading(): Boolean
}