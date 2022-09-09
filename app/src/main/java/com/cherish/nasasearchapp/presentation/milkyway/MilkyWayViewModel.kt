package com.cherish.nasasearchapp.presentation.milkyway

import androidx.lifecycle.ViewModel
import com.cherish.apimodule.common.Resource
import com.cherish.apimodule.data.model.response.Link
import com.cherish.apimodule.domain.MilkyWayUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MilkyWayViewModel @Inject constructor(private val milkyWayUseCases: MilkyWayUseCases): ViewModel() {
    fun getMilkyWayImages() =
        milkyWayUseCases.getMilkyWayImages()
        .catch {
        emit(Resource.Error(it))
        }
//    var getMilkyWayImages = milkyWayUseCases
//        .getMilkyWayImages().map { res ->
//            res.data?.let { MilkyWayItem(it) }
////            when(res){
////                is Resource.Success ->{
////                    res.data?.collection
////                }
////                is Resource.Error -> res.error
////                is Resource.Loading -> res.loading
////            }
//        }
}




// res.data?.let { MilkyWayItem(it) }