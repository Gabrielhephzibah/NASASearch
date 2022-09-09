package com.cherish.apimodule.domain

import com.cherish.apimodule.common.Resource
import com.cherish.apimodule.data.model.response.MilkyWayResponse
import kotlinx.coroutines.flow.Flow

interface MilkyWayUseCases {
    fun getMilkyWayImages(): Flow<Resource<MilkyWayResponse?>>
}