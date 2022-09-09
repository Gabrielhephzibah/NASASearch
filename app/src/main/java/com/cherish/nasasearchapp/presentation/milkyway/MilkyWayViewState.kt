package com.cherish.nasasearchapp.presentation.milkyway

import android.content.Context
import com.cherish.apimodule.common.Resource
import com.cherish.nasasearchapp.R
import com.cherish.nasasearchapp.common.BaseViewState

class MilkyWayViewState<T>(
    private val loadState: Resource<T>
): BaseViewState() {
    fun getProgressBarVisibility() = getViewVisibility(isVisible = loadState is Resource.Loading)

    fun getRecyclerViewVisibility() = getViewVisibility(isVisible = loadState !is Resource.Loading)

    fun getErrorVisibility() = getViewVisibility(isVisible = loadState is Resource.Error)

    fun getErrorMessage(context: Context) = if (loadState is Resource.Error) {
        loadState.error?.localizedMessage ?: context.getString(R.string.error)
    } else ""
}