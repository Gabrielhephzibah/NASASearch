package com.cherish.apimodule.domain

import com.cherish.apimodule.common.Constant
import com.cherish.apimodule.common.Resource
import com.cherish.apimodule.data.MilkyWayService
import com.cherish.apimodule.data.model.response.MilkyWayResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MilkyWayUseCasesImpl @Inject constructor(private val milkyWayService: MilkyWayService):MilkyWayUseCases {

    override fun getMilkyWayImages(): Flow<Resource<MilkyWayResponse?>> = flow {
        val response = milkyWayService.getMilkyWayImages(
            Constant.SEARCH_QUERY,
            Constant.MEDIA_TYPE_QUERY,
            Constant.YEAR_START_QUERY,
            Constant.YEAR_END_QUERY)
        //emit(Resource.Loading(false))
        emit(Resource.Success(response)) //
    }.flowOn(Dispatchers.IO)


//        .onCompletion { emit(Resource.Loading(false)) }
//        .catch {
//            emit(Resource.Error(it))
//           // emit(Resource.Loading(false))
//        }

}